import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m, price, profit;
    static int[] prices;

    public static void main(String[] args) {
        input();
        sellEgg();
        System.out.println(price + " " + profit);
    }
    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        prices = new int[m];

        for(int idx = 0; idx < m; idx++) {
            prices[idx] = sc.nextInt();
        }
        Arrays.sort(prices);
    }

    static void sellEgg() {
        for(int eggIdx = 0; eggIdx < m; eggIdx++) {
            int sum = prices[eggIdx] * ((m - eggIdx) <= n ? (m - eggIdx) : n);
            if(profit < sum) {
                profit = sum;
                price = prices[eggIdx];
            }
        }
    }

}