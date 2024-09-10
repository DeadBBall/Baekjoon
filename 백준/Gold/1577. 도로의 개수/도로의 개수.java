import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m, k;
    static long[][] dp;
    static boolean[][] xBoard, yBoard;

    public static void main(String[] args) {
        input();
        count();
        System.out.println(dp[m][n]);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        dp = new long[m + 1][n + 1];
        xBoard = new boolean[m + 1][n + 1];
        yBoard = new boolean[m + 1][n + 1];

        for(int idx = 0; idx < k; idx++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();

            if(a == c) {
                yBoard[Math.min(b, d)][a] = true;
            } else {
                xBoard[b][Math.min(a, c)] = true;
            }
        }
    }

    static void count() {
        for(int y = 1; y <= m; y++) {
            if(yBoard[y - 1][0]) break;

            dp[y][0] = 1;
        }

        for(int x = 1; x <= n; x++) {
            if(xBoard[0][x - 1]) break;

            dp[0][x] = 1;
        }

        for(int y = 1; y <= m; y++) {
            for(int x = 1; x <= n; x++) {
                if(!yBoard[y - 1][x]) {
                    dp[y][x] += dp[y - 1][x];
                }

                if(!xBoard[y][x - 1]) {
                    dp[y][x] += dp[y][x - 1];
                }
            }
        }
    }
}