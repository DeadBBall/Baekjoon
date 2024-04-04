import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int ONE = 10000;
    static final int THREE = 25000;
    static final int FIVE = 37000;
    static Scanner sc = new Scanner(System.in);
    static boolean[] breakDays;
    static int n, m;
    static int[][] dp;

    public static void main(String[] args) {
        input();
        System.out.println(goResort(1, 0));
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();

        breakDays = new boolean[n + 1];

        for (int idx = 0; idx < m; idx++) {
            breakDays[sc.nextInt()] = true;
        }

        dp = new int[n + 1][n + 1];

        for(int idx = 0; idx <= n; idx++) {
            Arrays.fill(dp[idx], -1);
        }
    }

    static int goResort(int day, int coupon) {
        if(day > n) return 0;

        if(dp[day][coupon] != -1) return dp[day][coupon];

        dp[day][coupon] = Integer.MAX_VALUE;

        if(breakDays[day]) {
            return dp[day][coupon] = Math.min(dp[day][coupon], goResort(day + 1, coupon));
        }
        else {
            if(coupon >= 3) {
                dp[day][coupon] = Math.min(dp[day][coupon], goResort(day + 1, coupon - 3));
            }
            dp[day][coupon] = Math.min(dp[day][coupon], goResort(day + 1, coupon) + ONE);
            dp[day][coupon] = Math.min(dp[day][coupon], goResort(day + 3, coupon + 1) + THREE);
            dp[day][coupon] = Math.min(dp[day][coupon], goResort(day + 5, coupon + 2) + FIVE);
        }

        return dp[day][coupon];
    }

}