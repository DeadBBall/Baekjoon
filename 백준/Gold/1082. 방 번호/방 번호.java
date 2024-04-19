import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static String ans;
    static int[] costs;
    static String[] dp;

    public static void main(String[] args) {
        input();
        makeMaxNumber();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        costs = new int[n];

        for(int number = 0; number < n; number++) {
            costs[number] = sc.nextInt();
        }

        m = sc.nextInt();

        dp = new String[m + 1];
        Arrays.fill(dp, "");

        for(int number = n - 1; number >= 1; number--) {
            if(costs[number] > m) continue;

            if (dp[costs[number]].isEmpty()) {
                dp[costs[number]] += number;
            }
        }

        ans = "0";
    }

    static void makeMaxNumber() {
        for(int money = 0; money <= m; money++) {
            if(dp[money].isEmpty()) continue;

            for(int number = 0; number < n; number++) {
                int cost = costs[number] + money;

                if(cost <= m) {
                    String newNumber = dp[money] + number;
                    String newNumber2 = number + dp[money];

                    dp[cost] = max(dp[cost], max(newNumber, newNumber2));
                }
            }
            ans = max(ans, dp[money]);
        }
    }

    static String max(String a, String b) {
        if(a.length() == b.length()) {
            return a.compareTo(b) > 0 ? a : b;
        }

        return a.length() > b.length() ? a : b;
    }

}