import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static final char EMPTY = '0';
    static int n, m;
    static char[][] board;
    static int[][] dp;
    static int maxSquare;

    public static void main(String[] args) {
        input();
        searchMaxSquare();
        System.out.println(maxSquare);
    }

    static void input() {
       n = sc.nextInt();
       m = sc.nextInt();

       board = new char[n + 1][m + 1];
       dp = new int[n + 1][m + 1];

       for(int y = 1; y <= n; y++) {
           String inputBoard = sc.next();
           for(int x = 1; x <= m; x++) {
               board[y][x] = inputBoard.charAt(x - 1);
           }
       }
    }

    static void searchMaxSquare() {
        int maxLen = 0;
        for(int y = 1; y <= n; y++) {
            for(int x = 1; x <= m; x++) {
                if(board[y][x] != EMPTY) {
                    dp[y][x] = Math.min(Math.min(dp[y - 1][x - 1], dp[y - 1][x]), dp[y][x - 1]) + 1;
                    maxLen = Math.max(dp[y][x], maxLen);
                }
            }
        }

        maxSquare = (int)Math.pow(maxLen, 2);
    }
}