import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static long[] dp;

    public static void main(String[] args) {
        input();
        calculateNumber();
        System.out.println(dp[n]);
    }
    static void input() {
        n = sc.nextInt();
        dp = new long[36];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
    }

    static void calculateNumber() {
        for(int num = 4; num <= n; num++) {
            for(int idx = 0; idx < num; idx++) {
                dp[num] += dp[num - 1 - idx] * dp[idx];
            }
        }
    }

}