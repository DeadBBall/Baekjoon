import java.util.Scanner;

public class Main {
    static final int WALL = 1;
    static final int RIGHT = 0;
    static final int DIAGONAL = 1;
    static final int DOWN = 2;
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int[][] board;
    static long[][][] dp;

    public static void main(String[] args) {
        input();
        movePipe();
        System.out.println(dp[n - 1][n - 1][RIGHT] + dp[n - 1][n - 1][DIAGONAL] + dp[n - 1][n - 1][DOWN]);
    }

    static void input() {
        n = sc.nextInt();
        dp = new long[n][n][3];
        board = new int[n][n];

        for(int y = 0; y < n; y++) {
            for(int x = 0; x < n; x++) {
                board[y][x] = sc.nextInt();
            }
        }
    }

    static void movePipe() {
        dp[0][1][RIGHT] = 1;

        for(int y = 0; y < n; y++) {
            for(int x = 2; x < n; x++) {
                if(board[y][x] == WALL) continue;

                dp[y][x][RIGHT] = dp[y][x - 1][RIGHT]+dp[y][x - 1][DIAGONAL];

                if(y == 0) continue;

                dp[y][x][DOWN] = dp[y - 1][x][DOWN] + dp[y - 1][x][DIAGONAL];

                if(board[y - 1][x] == WALL || board[y][x - 1] == WALL) continue;

                dp[y][x][DIAGONAL] = dp[y - 1][x - 1][RIGHT] + dp[y - 1][x - 1][DIAGONAL] + dp[y - 1][x - 1][DOWN];
            }
        }
    }
}