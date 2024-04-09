import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Paper[] papers;
    static int[] dp;
    static int n, ans;

    public static void main(String[] args) {
        input();
        pilePapers();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        papers = new Paper[n];
        dp = new int[n];

        for(int paperIdx = 0; paperIdx < n; paperIdx++) {
            int y = sc.nextInt();
            int x = sc.nextInt();

            if(x > y) {
                int tmp = x;
                x = y;
                y = tmp;
            }

            papers[paperIdx] = new Paper(y, x);
        }

        Arrays.sort(papers, new Comparator<Paper>() {
            @Override
            public int compare(Paper o1, Paper o2) {
                if(o1.y == o2.y) return o2.x - o1.x;
                return o2.y - o1.y;
            }
        });
    }

    static void pilePapers() {
        for(int right = 0; right < n; right++) {
            dp[right] = 1;
            Paper small = papers[right];

            for(int left = 0; left < right; left++) {
                Paper big = papers[left];

                if((big.y >= small.y && big.x >= small.x) || (big.y >= small.x && big.x >= small.y)) {
                    dp[right] = Math.max(dp[right], dp[left] + 1);
                }
            }
            ans = Math.max(ans, dp[right]);
        }
    }

}

class Paper {
    int y;
    int x;

    Paper(int y, int x) {
        this.y = y;
        this.x = x;
    }
}