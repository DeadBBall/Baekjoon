import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m, ans;
    static Candy[] candies;
    static int[] dp;
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {

        while(true) {
            input();
            if(n == 0 && m == 0) break;
            calculateHighCalorie();
        }
        System.out.println(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        m = (int)(sc.nextFloat() * 100.0 + 0.5);
        if(n == 0 && m == 0) return;

        dp = new int[m + 1];
        candies = new Candy[n];
        ans = 0;

        for(int candyIdx = 0; candyIdx < n; candyIdx++) {
            int calorie = sc.nextInt();
            int cost = (int)(sc.nextFloat() * 100.0 + 0.5);
            candies[candyIdx] = new Candy(calorie, cost);
        }

        Arrays.sort(candies, new Comparator<Candy>() {
            @Override
            public int compare(Candy o1, Candy o2) {
                return o1.cost - o2.cost;
            }
        });
    }

    static void calculateHighCalorie() {
        for(int candyIdx = 0; candyIdx < n; candyIdx++) {
            for(int money = candies[candyIdx].cost; money <= m; money++) {

                dp[money] = Math.max(dp[money], dp[money - candies[candyIdx].cost] + candies[candyIdx].calorie);
                ans = Math.max(dp[money], ans);
            }
        }
        ansMaker.append(ans).append("\n");
    }

    static class Candy {
        int calorie;
        int cost;

        public Candy(int calorie, int cost) {
            this.calorie = calorie;
            this.cost = cost;
        }
    }
}