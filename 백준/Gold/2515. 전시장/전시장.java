import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, s;
    static Picture[] pictures;
    static int[][] dp;

    public static void main(String[] args) {
        input();
        exhibit();
        System.out.println(Math.max(dp[n - 1][0], dp[n - 1][1]));
    }

    static void input() {
        n = sc.nextInt();
        s = sc.nextInt();

        pictures = new Picture[n];

        for(int idx = 0; idx < n; idx++) {
            pictures[idx] = new Picture(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(pictures, new Comparator<Picture>() {
            @Override
            public int compare(Picture o1, Picture o2) {
                if(o1.height == o2.height) return o1.value - o2.value;

                return o1.height - o2.height;
            }
        });

        dp = new int[n][2];
    }

    static void exhibit() {
        dp[0][1] = pictures[0].value;

        for(int idx = 1; idx < n; idx++) {
            dp[idx][1] = pictures[idx].value;

            int left = 0;
            int right = idx;

            while(left < right) {
                int mid = (left + right) >> 1;

                if(pictures[mid].height + s <= pictures[idx].height) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            dp[idx][0] = Math.max(dp[idx - 1][0], dp[idx - 1][1]);

            if(left > 0) {
                dp[idx][1] = Math.max(dp[left - 1][0], dp[left - 1][1]) + pictures[idx].value;
            }
        }
    }
}

class Picture {
    int height;
    int value;

    public Picture(int height, int value) {
        this.height = height;
        this.value = value;
    }
}