import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int c;
    static int n;
    static int[] costs;
    static int[] guests;
    static int[] dp;

    public static void main(String[] args) {
        input();
        promote();
    }

    static void input() {
        c = sc.nextInt();
        n = sc.nextInt();

        costs = new int[n + 1];
        guests = new int[n + 1];

        for (int cityCnt = 1; cityCnt <= n; cityCnt++) {
            costs[cityCnt] = sc.nextInt();
            guests[cityCnt] = sc.nextInt();
        }

        dp = new int[100 + c];
        Arrays.fill(dp, 1111111);
        dp[0] = 0;

    }

    static void promote() {

        for (int cityIdx = 1; cityIdx <= n; cityIdx++) {

            int nowCost = costs[cityIdx];
            int nowGuest = guests[cityIdx];

            for (int guest = nowGuest; guest <= c + 99; guest++) {
                dp[guest] = Math.min(dp[guest - nowGuest] + nowCost, dp[guest]);
            }

        }

        int ans = Integer.MAX_VALUE;

        for (int guest = c; guest <= c + 99; guest++) {
            ans = Math.min(dp[guest], ans);
        }

        System.out.println(ans);

    }

}