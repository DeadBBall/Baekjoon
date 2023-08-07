import java.awt.print.Pageable;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int m;
    static int[] memories;
    static int[] costs;
    static int[][] dp;
    static int maxCost;

    public static void main(String[] args) {
        input();
        forceQuit();
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();

        memories = new int[n];
        costs = new int[n];

        for(int idx = 0; idx < n; idx++) {
            memories[idx] = sc.nextInt();
        }

        for(int idx = 0; idx < n; idx++) {
            costs[idx] = sc.nextInt();
        }

        maxCost = Arrays.stream(costs).sum();

        dp = new int[n + 1][maxCost + 1];

    }

    static void forceQuit() {
        for(int i = 0; i < n; i++) {
            int nowMemory = memories[i];
            int nowCost = costs[i];

            for(int j = 0; j <= maxCost; j++) {

                if(nowCost <= j) {
                    dp[i + 1][j] = Math.max(dp[i][j - nowCost] + nowMemory, dp[i][j]);
                } else {
                    dp[i + 1][j] = dp[i][j];
                }

            }

        }

        for(int i = 0; i <= maxCost; i++) {

            if(dp[n][i] >= m) {
                System.out.println(i);
                break;
            }

        }

    }


}
