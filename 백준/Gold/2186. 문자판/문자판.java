import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] DY = {1, -1, 0, 0};
    static int[] DX = {0, 0, 1, -1};
    static Scanner sc = new Scanner(System.in);
    static int n, m, k, ans;
    static int[][][] dp;
    static String[] board;
    static String target;

    public static void main(String[] args) {
        input();
        findStr();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        board = new String[n];

        for(int y = 0; y < n; y++) {
            board[y] = sc.next();
        }

        target = sc.next();

        dp = new int[target.length()][n][m];
        for(int size = 0; size < target.length(); size++) {
            for(int y = 0; y < n; y++) {
                Arrays.fill(dp[size][y], -1);
            }
        }

    }

    static void findStr() {
        for(int y = 0; y < n; y++) {
            for(int x = 0; x < m; x++) {
                if(board[y].charAt(x) == target.charAt(0)) {
                    ans += dfs(y, x, 1);
                }
            }
        }
    }

    static int dfs(int y, int x, int idx) {
        if(idx == target.length()) return 1;

        if(dp[idx][y][x] != -1) return dp[idx][y][x];

        dp[idx][y][x] = 0;

        for(int drct = 0; drct < 4; drct++) {
            for(int size = 1; size <= k; size++) {
                int ny = y + DY[drct] * size;
                int nx = x + DX[drct] * size;

                if(!canMove(ny, nx)) continue;

                if(board[ny].charAt(nx) == target.charAt(idx)) {
                    dp[idx][y][x] += dfs(ny, nx, idx + 1);
                }
            }
        }

        return dp[idx][y][x];
    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}