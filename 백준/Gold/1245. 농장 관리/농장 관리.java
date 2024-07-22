import java.util.*;

public class Main {
    static final int[] DY = {1, -1, 0, 0, 1, 1, -1, -1};
    static final int[] DX = {0, 0, 1, -1, 1, -1, 1, -1};
    static Scanner sc = new Scanner(System.in);
    static int n, m, ans;
    static int[][] board;
    static boolean[][] visit;

    public static void main(String[] args) {
        input();
        countPeaks();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();

        board = new int[n][m];
        visit = new boolean[n][m];

        for(int y = 0; y < n; y++) {
            for(int x = 0; x < m; x++) {
                board[y][x] = sc.nextInt();
            }
        }
    }

    static void countPeaks() {
        Queue<Position> peaks = new LinkedList<>();

        for(int y = 0; y < n; y++) {
            for(int x = 0; x < m; x++) {
                if(!visit[y][x]) {
                    Position now = new Position(y, x);
                    peaks.add(now);
                    visit[y][x] = true;

                    dfs(peaks, now, board[y][x]);

                    if(isPeak(peaks, board[y][x])) ans++;
                }
            }
        }
    }

    static void dfs(Queue<Position> peaks, Position now, int height) {
        for(int drct = 0; drct < 8; drct++) {
            int ny = now.y + DY[drct];
            int nx = now.x + DX[drct];

            if(!canMove(ny, nx) || visit[ny][nx]) continue;

            if(height == board[ny][nx]) {
                visit[ny][nx] = true;

                Position next = new Position(ny, nx);
                peaks.add(next);
                dfs(peaks, next, height);
            }
        }
    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }

    static boolean isPeak(Queue<Position> peaks, int height) {
        boolean result = true;

        while(!peaks.isEmpty()) {
            Position now = peaks.remove();

            for(int drct = 0; drct < 8; drct++) {
                int ny = now.y + DY[drct];
                int nx = now.x + DX[drct];

                if(!canMove(ny, nx)) continue;

                if(board[ny][nx] > height) result = false;
            }
        }

        return result;
    }
}

class Position {
    int y;
    int x;

    Position(int y, int x) {
        this.y = y;
        this.x = x;
    }
}