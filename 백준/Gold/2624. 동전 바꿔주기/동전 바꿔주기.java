import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int t, k;
    static Coin[] coins;
    static int[] dp;

    public static void main(String[] args) {
        input();
        exchangeCoins();
        System.out.println(dp[t]);
    }

    static void input() {
        t = sc.nextInt();
        k = sc.nextInt();

        coins = new Coin[k];

        for(int coinIdx = 0; coinIdx < k; coinIdx++) {
            int p = sc.nextInt();
            int n = sc.nextInt();

            coins[coinIdx] = new Coin(p, n);
        }

        dp = new int[t + 1];
        dp[0] = 1;
    }

    static void exchangeCoins() {
        for(int coinIdx = 0; coinIdx < k; coinIdx++) {

            for(int money = t; money >= coins[coinIdx].value; money--) {

                for(int coinCount = 1; coinCount <= coins[coinIdx].count; coinCount++) {
                    if(money - coins[coinIdx].value * coinCount < 0) break;

                    dp[money] += dp[money - coins[coinIdx].value * coinCount];
                }
            }
        }
    }

}

class Coin {
    int value;
    int count;

    Coin(int value, int count) {
        this.value = value;
        this.count = count;
    }
}