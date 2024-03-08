import java.util.*;

public class Main {
    static final int[] DY = {1, 0, 0};
    static final int[] DX = {0, 1, -1};
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static int[][] board, dp;

    public static void main(String[] args) {
        input();
        exploreArea();
        System.out.println(dp[n - 1][m - 1]);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        dp = new int[n][m];
        board = new int[n][m];

        for(int y = 0; y < n; y++) {
            for(int x = 0; x < m; x++) {
                board[y][x] = sc.nextInt();
            }
        }

    }

    static void exploreArea() {
        int[][] tmp = new int[2][m];

        dp[0][0] = board[0][0];

        for(int x = 1; x < m; x++) {
            dp[0][x] = dp[0][x - 1] + board[0][x];
        }

        for(int y = 1; y < n; y++) {

            tmp[0][0] = dp[y - 1][0] + board[y][0];

             for(int x = 1; x < m; x++) {
                 tmp[0][x] = Math.max(tmp[0][x - 1], dp[y - 1][x]) + board[y][x];
             }

             tmp[1][m - 1] = dp[y - 1][m - 1] + board[y][m - 1];

             for(int x = m - 2; x >= 0; x--) {
                 tmp[1][x] = Math.max(tmp[1][x + 1], dp[y - 1][x]) + board[y][x];
             }

             for(int x = 0; x < m; x++) {
                 dp[y][x] = Math.max(tmp[0][x], tmp[1][x]);
             }
        }
    }
}