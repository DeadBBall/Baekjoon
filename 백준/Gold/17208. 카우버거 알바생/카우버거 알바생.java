import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m, k, ans;
    static Order[] orders;
    static int[][][] dp;

    public static void main(String[] args) {
        input();
        countOrder();
        System.out.println(dp[n][m][k]);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        orders = new Order[n + 1];

        for(int idx = 1; idx <= n; idx++) {
            orders[idx] = new Order(sc.nextInt(), sc.nextInt());
        }

        dp = new int[n + 1][m + 1][k + 1];
    }

    static void countOrder() {
        for(int idx = 1; idx <= n; idx++) {
            for(int b = m; b >= 1; b--) {
                for(int p = k; p >= 1; p--) {
                    dp[idx][b][p] = dp[idx - 1][b][p];

                    int nowB = orders[idx].burger;
                    int nowP = orders[idx].potato;

                    if(nowB <= b && nowP <= p) {
                        dp[idx][b][p] = Math.max(dp[idx][b][p], dp[idx - 1][b - nowB][p - nowP] + 1);
                    }
                }
            }
        }
    }
}

class Order {
    int burger;
    int potato;

    public Order(int burger, int potato) {
        this.burger = burger;
        this.potato = potato;
    }
}