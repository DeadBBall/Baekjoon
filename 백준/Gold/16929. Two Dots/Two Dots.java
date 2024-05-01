import java.util.*;

public class Main {
    static final int[] DY = {0, -1, 0, 1};
    static final int[] DX = {-1, 0, 1, 0};
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static String[] board;
    static boolean[][] visit;

    public static void main(String[] args) {
        input();
        System.out.println(playTwoDots() ? "Yes" : "No");
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        board = new String[n];
        visit = new boolean[n][m];

        for(int y = 0; y < n; y++) {
            board[y] = sc.next();
        }
    }

    static boolean playTwoDots() {
        for(int y = 0; y < n; y++) {
            for(int x = 0; x < m; x++) {
                if(findCycle(y, x, y, x, 1)) return true;
            }
        }

        return false;
    }

    static boolean findCycle(int startY, int startX, int nowY, int nowX, int dotCnt) {
        visit[nowY][nowX] = true;

        for(int drct = 0; drct < 4; drct++) {
            int ny = nowY + DY[drct];
            int nx = nowX + DX[drct];

            if(!canMove(ny, nx) || board[startY].charAt(startX) != board[ny].charAt(nx)) continue;

            if(dotCnt >= 4 && ny == startY && nx == startX) {
                return true;
            }

            if(visit[ny][nx]) continue;

            visit[ny][nx] = true;

            if(findCycle(startY, startX, ny, nx, dotCnt + 1)) {
                visit[ny][nx] = false;
                return true;
            }

            visit[ny][nx] = false;
        }
        visit[nowY][nowX] = false;

        return false;
    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}