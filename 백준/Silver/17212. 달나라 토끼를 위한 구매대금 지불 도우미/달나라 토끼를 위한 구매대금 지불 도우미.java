import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int[] coins = {1, 2, 5, 7};
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
        for(int coin : coins) {
            for (int money = coin; money <= n; money++) {
                dp[money] = Math.min(dp[money - coin] + 1, dp[money]);
            }
        }
    }
}