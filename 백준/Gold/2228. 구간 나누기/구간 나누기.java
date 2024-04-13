import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static int[] sum;
    static int[][] dp;

    public static void main(String[] args) {
        input();
        divideSections();
        System.out.println(dp[n][m]);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        sum = new int[n + 1];

        for (int numIdx = 1; numIdx <= n; numIdx++) {
            int num = sc.nextInt();
            sum[numIdx] = sum[numIdx - 1] + num;
        }

        dp = new int[n + 1][m + 1];

        Arrays.fill(dp[0], -3276800);
        dp[0][0] = 0;
    }

    static void divideSections() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];

                for (int k = 1; k <= i; k++) {
                    if (k >= 2) {
                        dp[i][j] = Math.max(dp[i][j], dp[k - 2][j - 1] + sum[i] - sum[k - 1]);
                    } else if (k == 1 && j == 1) {
                        dp[i][j] = Math.max(dp[i][j], sum[i]);
                    }
                }
            }
        }
    }
}