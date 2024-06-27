import java.util.Scanner;

public class Main {
    static final int MOD = 1_000_000_007;
    static Scanner sc = new Scanner(System.in);
    static int n;
    static long[][] dp;

    public static void main(String[] args){
        input();
        playGame();
        System.out.print(dp[n + 1][1]);
    }

    static void input() {
        n = sc.nextInt();
        dp = new long[1002][2];
        dp[1][0] = 1;
        dp[2][0] = 1;
        dp[3][0] = 2;
        dp[3][1] = 1;
    }

    static void playGame() {
        for(int len = 4; len <= n + 1; len++) {
            dp[len][0] = (dp[len - 1][0] + dp[len - 2][0] + dp[len - 3][0]) % MOD;
            dp[len][1] = (dp[len - 1][1] + dp[len - 2][0] + dp[len - 2][1] * 2
                    + dp[len - 3][0] * 2 + dp[len - 3][1] * 3) % MOD;
        }
    }

}