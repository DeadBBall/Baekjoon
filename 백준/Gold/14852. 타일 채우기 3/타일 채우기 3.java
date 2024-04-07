import java.util.Scanner;

public class Main {
    static final int MOD = 1000000007;
    static Scanner sc = new Scanner(System.in);
    static int n;
    static long[] dp;

    public static void main(String[] args) {
        input();
        fillWithTiles();
        System.out.println(dp[n]);
    }

    static void input() {
        n = sc.nextInt();
        dp = new long[n + 2];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 7;
    }

    static void fillWithTiles() {
        long temp = (dp[2] + dp[1] + dp[0]) * 2;

        for(int idx = 3; idx <= n; idx++) {
            dp[idx] = (temp + dp[idx - 2]) % MOD;
            temp = (temp + dp[idx] * 2) % MOD;
        }
    }

}