import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static long[] sums;
    static long ans;

    public static void main(String[] args) {
        input();
        cutInsect();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        sums = new long[n + 1];

        for(int idx = 1; idx <= n; idx++) {
            sums[idx] = sums[idx - 1] + sc.nextInt();
        }
    }

    static void cutInsect() {
        int y = n - 1;

        while(y > 1) {
            int left = 0;
            int right = y - 1;
            int prev = 0;

            while(left <= right) {
                int mid = (left + right) >> 1;

                long head = sums[mid];
                long chest = sums[y] - sums[mid];
                long stomach = sums[n] - sums[y];

                if(head < stomach && stomach < chest) {
                    ans += mid - prev;
                    prev = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            y--;
        }

    }
}