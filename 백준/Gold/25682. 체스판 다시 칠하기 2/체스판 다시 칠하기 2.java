import java.util.Scanner;

public class Main {
    static final char BLACK = 'B';
    static final char WHITE = 'W';
    static Scanner sc = new Scanner(System.in);
    static int n, m, k, ans;
    static String[] board;
    static int[][] dpW, dpB;

    public static void main(String[] args) {
        input();
        paintChessboard();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        dpW = new int[n + 1][m + 1];
        dpB = new int[n + 1][m + 1];
        board = new String[n];

        for(int y = 0; y < n; y++) {
            board[y] = sc.next();
        }

        ans = Integer.MAX_VALUE;
    }

    static void paintChessboard() {
        for(int y = 1; y <= n; y++) {
            for(int x = 1; x <= m; x++) {
                dpW[y][x] = dpW[y][x - 1] + dpW[y - 1][x] - dpW[y - 1][x - 1];
                dpB[y][x] = dpB[y][x - 1] + dpB[y - 1][x] - dpB[y - 1][x - 1];

                if((y + x) % 2 == 1) {
                    if(board[y - 1].charAt(x - 1) == BLACK) {
                        dpB[y][x]++;
                    }
                    else {
                        dpW[y][x]++;
                    }
                }
                if((y + x) % 2 == 0) {
                    if(board[y - 1].charAt(x - 1) == WHITE) {
                        dpB[y][x]++;
                    }
                    else {
                        dpW[y][x]++;
                    }
                }
            }
        }

        for(int y = 0; y <= n - k; y++) {
            for(int x = 0; x <= m - k; x++) {
                ans = Math.min(ans, dpW[y + k][x + k] - dpW[y][x + k] - dpW[y + k][x] + dpW[y][x]);
                ans = Math.min(ans, dpB[y + k][x + k] - dpB[y][x + k] - dpB[y + k][x] + dpB[y][x]);
            }
        }
    }

}