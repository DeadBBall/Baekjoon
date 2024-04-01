import java.util.Scanner;

public class Main {
    static final int MOD = 1000000;
    static Scanner sc = new Scanner(System.in);
    static int[][][] dp;
    static int n;

    public static void main(String[] args) {
        input();
        givePerfectAttendanceAwards();
        System.out.println((dp[n][0][0] + dp[n][0][1] + dp[n][0][2] + dp[n][1][0] + dp[n][1][1] + dp[n][1][2]) % MOD);
    }

    static void input() {
        n = sc.nextInt();

        dp = new int[n + 1][2][3];

        dp[1][0][0] = dp[1][1][0] = dp[1][0][1] = 1;
    }

    static void givePerfectAttendanceAwards() {
        for(int day = 2; day <= n; day++) {
            dp[day][0][0] = (dp[day - 1][0][0] + dp[day - 1][0][1] + dp[day - 1][0][2]) % MOD;
            dp[day][0][1] = dp[day - 1][0][0];
            dp[day][0][2] = dp[day - 1][0][1];

            dp[day][1][0] = (dp[day - 1][0][0] + dp[day - 1][0][1] + dp[day - 1][0][2]
                    + dp[day - 1][1][0] + dp[day - 1][1][1] + dp[day - 1][1][2]) % MOD;
            dp[day][1][1] = dp[day - 1][1][0];
            dp[day][1][2] = dp[day - 1][1][1];
        }
    }
}