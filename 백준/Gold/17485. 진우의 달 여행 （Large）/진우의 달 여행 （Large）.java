import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m, ans;
    static int[][] board;
    static int[][][] dp;

    public static void main(String[] args) {
        input();
        travel();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];
        dp = new int[n][m][3];

        for(int y = 0; y < n; y++) {
            for(int x = 0; x < m; x++) {
                board[y][x] = sc.nextInt();
                Arrays.fill(dp[y][x], 1234567);

                if(y == 0) {
                    for(int drct = 0; drct < 3; drct++) {
                        dp[y][x][drct] = board[y][x];
                    }
                }
            }
        }

        ans = Integer.MAX_VALUE;
    }

    static void travel() {
        for(int y = 1; y < n; y++) {
            for(int x = 0; x < m; x++) {
                if(x == 0) {
                    dp[y][x][1] = dp[y - 1][x][2] + board[y][x];
                    dp[y][x][2] = Math.min(dp[y - 1][x + 1][1], dp[y - 1][x + 1][0]) + board[y][x];
                } else if(x == m - 1) {
                    dp[y][x][0] = Math.min(dp[y - 1][x - 1][1], dp[y - 1][x - 1][2]) + board[y][x];
                    dp[y][x][1] = dp[y - 1][x][0] + board[y][x];
                } else {
                    dp[y][x][0] = Math.min(dp[y - 1][x - 1][1], dp[y - 1][x - 1][2]) + board[y][x];
                    dp[y][x][1] = Math.min(dp[y - 1][x][0], dp[y - 1][x][2]) + board[y][x];
                    dp[y][x][2] = Math.min(dp[y - 1][x + 1][1], dp[y - 1][x + 1][0]) + board[y][x];
                }
            }
        }

        for(int x = 0; x < m; x++) {
            for(int drct = 0; drct < 3; drct++) {
                ans = Math.min(ans, dp[n - 1][x][drct]);
            }
        }
    }
}