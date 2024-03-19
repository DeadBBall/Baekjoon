import java.util.Scanner;

public class Main {
    static final int MOD = 1000000003;
    static Scanner sc = new Scanner(System.in);
    static int n, k;
    static int[][] dp;

    public static void main(String[] args) {
        input();
        checkColoredRing();
        System.out.println(dp[n][k]);
    }

    static void input() {
        n = sc.nextInt();
        k = sc.nextInt();
        dp = new int[n + 1][k + 1];
        dp[2][0] = dp[3][0] = 1;
        dp[2][1] = 2;
        dp[3][1] = 3;
    }

    static void checkColoredRing() {
        for(int total = 4; total <= n; total++) {
            dp[total][0] = 1;
            dp[total][1] = total;

            for(int kCount = 2; kCount <= k; kCount++) {
                dp[total][kCount] = (dp[total - 1][kCount] + dp[total - 2][kCount - 1]) % MOD;
            }
        }
    }

}