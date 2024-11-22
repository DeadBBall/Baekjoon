import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m, ans;
    static int[][] board;
    static int[][] sums;

    public static void main(String[] args) {
        input();
        playGame();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];
        sums = new int[n + 1][m + 1];

        ans = Integer.MIN_VALUE;

        for(int y = 0; y < n; y++) {
            for(int x = 0; x < m; x++) {
                board[y][x] = sc.nextInt();

                if(y == 0 || x == 0) {
                    sums[y + 1][x + 1] = board[y][x];
                }

                ans = Math.max(board[y][x], ans);
            }
        }

        for(int y = 0; y < n; y++) {
            for(int x = 0; x < m; x++) {
                sums[y + 1][x + 1] = sums[y + 1][x] + board[y][x] + sums[y][x + 1] - sums[y][x];
            }
        }
    }

    static void playGame() {
        for(int y = 1; y <= n; y++) {
            for(int x = 1; x <= m; x++) {
                for(int y2 = y; y2 <= n; y2++) {
                    for(int x2 = x; x2 <= m; x2++) {
                        ans = Math.max(ans, sums[y2][x2] - sums[y - 1][x2] - sums[y2][x - 1] + sums[y - 1][x - 1]);
                    }
                }
            }
        }
    }
}