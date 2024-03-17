import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, k;
    static int[][] dp;

    public static void main(String[] args) {
        input();
        findNumber();
        System.out.println(dp[n][k]);
    }

    static void input() {
        n = sc.nextInt();
        k = sc.nextInt();

        dp = new int[n + 1][k + 1];
    }

    static void findNumber() {
        dp[1][1] = 1;

        for(int y = 2; y <= n; y++) {
            for(int x = 1; x <= k; x++) {
                dp[y][x] = dp[y - 1][x] + dp[y - 1][x - 1];
            }
        }
    }

}