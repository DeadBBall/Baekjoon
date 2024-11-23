import java.util.*;

public class Main {
    static final int[] DY = {0, 1};
    static final int[] DX = {1, 0};
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static int[][] board, dp;

    public static void main(String[] args) {
        input();
        getResources();
        System.out.println(dp[n][m]);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];
        dp = new int[n + 1][m + 1];

        for(int y = 0; y < n; y++) {
            for(int x = 0; x < m; x++) {
                board[y][x] = sc.nextInt();
            }
        }
    }

    static void getResources() {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + board[i - 1][j - 1];
            }
        }
    }

}