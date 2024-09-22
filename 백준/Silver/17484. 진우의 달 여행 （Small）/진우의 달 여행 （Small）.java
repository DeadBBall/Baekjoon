import java.util.*;

public class Main {
    static final int[] DY = {1, 1, 1};
    static final int[] DX = {-1, 0, 1};
    static Scanner sc = new Scanner(System.in);
    static int n, m, ans;
    static int[][] board;

    public static void main(String[] args) {
        input();
        travel();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];

        for(int y = 0; y < n; y++) {
            for(int x = 0; x < m; x++) {
                board[y][x] = sc.nextInt();
            }
        }

        ans = Integer.MAX_VALUE;
    }

    static void travel() {
        for(int x = 0; x < m; x++) {
            dfs(0, x, board[0][x], -1);
        }
    }

    static void dfs(int nowY, int nowX, int totalDist, int prevDrct) {
        if(nowY == n - 1) {
            ans = Math.min(ans, totalDist);
            return;
        }

        for(int drct = 0; drct < 3; drct++) {
            if(drct == prevDrct) continue;

            int ny = nowY + DY[drct];
            int nx = nowX + DX[drct];

            if(!canMove(ny, nx)) continue;

            dfs(ny, nx, totalDist + board[ny][nx], drct);
        }

    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}