import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int[] leftCards, rightCards;
    static int[][] dp;

    public static void main(String[] args) {
        input();
        System.out.println(playGame(0, 0));
    }

    static void input() {
        n = sc.nextInt();
        leftCards = new int[n];
        rightCards = new int[n];

        for(int cardIdx = 0; cardIdx < n; cardIdx++) {
            leftCards[cardIdx] = sc.nextInt();
        }

        for(int cardIdx = 0; cardIdx < n; cardIdx++) {
            rightCards[cardIdx] = sc.nextInt();
        }

        dp = new int[n + 1][n + 1];

        for(int idx = 0; idx <= n; idx++) {
            Arrays.fill(dp[idx], -1);
        }
    }

    static int playGame(int left, int right) {
        if(left == n || right == n) return dp[left][right] = 0;

        if(dp[left][right] != -1) return dp[left][right];

        int result = Math.max(playGame(left + 1, right + 1), playGame(left + 1, right));

        if(leftCards[left] > rightCards[right]) {
            result = Math.max(result, playGame(left, right + 1) + rightCards[right]);
        }

        return dp[left][right] = result;
    }

}
