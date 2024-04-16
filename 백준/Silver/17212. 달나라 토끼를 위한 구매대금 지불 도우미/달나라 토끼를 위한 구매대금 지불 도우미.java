import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int[] dp;

    public static void main(String[] args) {
        input();
        giveChange();
        System.out.println(dp[n]);
    }

    static void input() {
        n = sc.nextInt();
        dp = new int[n + 1];
        Arrays.fill(dp, 100001);
        dp[0] = 0;
    }

    static void giveChange() {
        for(int money = 1; money <= n; money++) {
            dp[money] = Math.min(dp[money - 1] + 1, dp[money]);
            
            if(money >= 2) {
                dp[money] = Math.min(dp[money - 2] + 1, dp[money]);
            }
            if(money >= 5) {
                dp[money] = Math.min(dp[money - 5] + 1, dp[money]);
            }
            if(money >= 7) {
                dp[money] = Math.min(dp[money - 7] + 1, dp[money]);
            }
        }
    }

}