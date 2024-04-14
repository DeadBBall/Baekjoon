import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int[][] dp;

    public static void main(String[] args) {
        input();
        find15();
        System.out.println(dp[n - 1][1]);
    }

    static void input() {
        n = sc.nextInt();
        dp = new int[n + 1][3];

        dp[1][1] = dp[1][2] = 1;
    }

    static void find15() {
        for(int idx = 2; idx < n; idx++) {
            dp[idx][0] = (dp[idx - 1][2] + dp[idx - 1][1]) % MOD;
            dp[idx][1] = (dp[idx - 1][0] + dp[idx - 1][2]) % MOD;
            dp[idx][2] = (dp[idx - 1][1] + dp[idx - 1][0]) % MOD;
        }
    }
}