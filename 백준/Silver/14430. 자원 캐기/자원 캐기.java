import java.util.*;

public class Main {
    static final int[] DY = {0, 1};
    static final int[] DX = {1, 0};
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static int[][] board, dp;

    public static void main(String[] args) {
        input();
        getResources();
        System.out.println(dp[n - 1][m - 1]);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];
        dp = new int[n][m];

        for(int y = 0; y < n; y++) {
            for(int x = 0; x < m; x++) {
                board[y][x] = sc.nextInt();
                dp[y][x] = -1;
            }
        }

        dp[0][0] = board[0][0];
    }

    static void getResources() {
        Queue<Point> points = new LinkedList<>();
        points.add(new Point(0, 0));

        while(!points.isEmpty()) {
            Point now = points.remove();

            for(int drct = 0; drct < 2; drct++) {
                int ny = now.y + DY[drct];
                int nx = now.x + DX[drct];

                if(ny >= n || nx >= m) continue;

                if(dp[ny][nx] < dp[now.y][now.x] + board[ny][nx]) {
                    dp[ny][nx] = dp[now.y][now.x] + board[ny][nx];
                    points.add(new Point(ny, nx));
                }
            }
        }
    }

}

class Point {
    int y;
    int x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}