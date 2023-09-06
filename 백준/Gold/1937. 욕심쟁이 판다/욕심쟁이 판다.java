import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static final int[] DY = {1, -1, 0, 0};
    static final int[] DX = {0, 0, 1, -1};
    static int n;
    static int[][] board;
    static int[][] dp;
    static int maxDist;


    public static void main(String[] args) {
        input();
        eatBamboo();
        System.out.println(maxDist);
    }

    static void input() {
       n = sc.nextInt();
       board = new int[n][n];
       dp = new int[n][n];

       for(int y = 0; y < n; y++) {
           for(int x = 0; x < n; x++) {
               board[y][x] = sc.nextInt();
           }
       }
    }

    static void eatBamboo() {
        for(int y = 0; y < n; y++) {
            for(int x = 0; x < n; x++) {
                if(dp[y][x] != 0) continue;
                
                maxDist = Math.max(dfs(new Point(y, x, 1)), maxDist);
            }
        }
    }

    static int dfs(Point now) {
        if(dp[now.y][now.x] != 0)
            return dp[now.y][now.x];

        dp[now.y][now.x] = 1;

        for(int drct = 0; drct < 4; drct++) {
            int ny = now.y + DY[drct];
            int nx = now.x + DX[drct];

            if(!canMove(ny, nx)) continue;

            if(board[now.y][now.x] >= board[ny][nx]) continue;

            int result = dfs(new Point(ny, nx, now.dist + 1));

            dp[now.y][now.x] = Math.max(dp[now.y][now.x], result + 1);
        }

        return dp[now.y][now.x];
    }

    static boolean canMove(int y, int x) {
        return !(y < 0 || x < 0 || y >= n || x >= n);
    }

    static class Point {
        int y;
        int x;
        int dist;

        public Point(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }

}