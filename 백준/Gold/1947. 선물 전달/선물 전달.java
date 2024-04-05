import java.util.Scanner;

public class Main {
    static final int MOD = 1000000000;
    static Scanner sc = new Scanner(System.in);
    static int n;
    static long[] dp;

    public static void main(String[] args) {
        input();
        giveGifts();
        System.out.println(dp[n]);
    }

    static void input() {
        n = sc.nextInt();
        dp = new long[n + 1];
        dp[0] = 1;
    }

    static void giveGifts() {
        for(int student = 2; student <= n; student++) {
            dp[student] = (student - 1) * (dp[student - 1] + dp[student - 2]) % MOD;
        }
    }
}