import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static int[] dp;

    public static void main(String[] args) {
        input();
        count();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        dp = new int[n + 1];
        dp[0] = dp[1] = 1;
    }

    static void count() {
        for(int idx = 2; idx <= n; idx++) {
            dp[idx] = dp[idx - 1] + dp[idx - 2] * 2;
        }

        ans = n % 2 == 1 ? (dp[n] + dp[n / 2]) / 2 :(dp[n / 2 - 1] * 2 + dp[n / 2] + dp[n]) / 2;
    }

}