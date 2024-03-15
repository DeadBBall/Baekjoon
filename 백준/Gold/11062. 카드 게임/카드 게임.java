import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker = new StringBuilder();
    static int n;
    static int[] cards;
    static int[][]dp;

    public static void main(String[] args) {
        int t = sc.nextInt();

        while(t-- > 0) {
            input();
            ansMaker.append(playGame(0, n - 1)).append("\n");
        }

        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        dp = new int[n][n];
        cards = new int[n];

        for(int cardIdx = 0; cardIdx < n; cardIdx++) {
            cards[cardIdx] = sc.nextInt();
        }
    }

    static int playGame(int left, int right) {
        if(left > right) return 0;

        if(dp[left][right] != 0) return dp[left][right];

        int turn = n - (left + right + 1);

        if(turn % 2 == 0) {
            dp[left][right] = Math.max(playGame(left + 1, right) + cards[left],
                    playGame(left, right - 1) + cards[right]);
        }
        else {
            dp[left][right] = Math.min(playGame(left + 1, right),
                    playGame(left, right - 1));
        }

        return dp[left][right];
    }

}