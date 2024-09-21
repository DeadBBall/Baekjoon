import java.util.*;

public class Main {
    static final char SHEEP = '#';
    static final int[] DY = {1, -1, 0, 0};
    static final int[] DX = {0, 0, 1, -1};
    static Scanner sc = new Scanner(System.in);
    static int h, w;
    static String[] board;
    static boolean[][] visit;
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {
        int t = sc.nextInt();

        while(t-- > 0) {
            input();
            countSheep();
        }

        System.out.print(ansMaker);
    }

    static void input() {
        h = sc.nextInt();
        w = sc.nextInt();
        visit = new boolean[h][w];
        board = new String[h];

        for(int idx = 0; idx < h; idx++) {
            board[idx] = sc.next();
        }
    }

    static void countSheep() {
        int cnt = 0;

        for(int y = 0; y < h; y++) {
            for(int x = 0; x < w; x++) {
                if(board[y].charAt(x) == SHEEP && !visit[y][x]) {
                    dfs(y, x);
                    cnt++;
                }
            }
        }

        ansMaker.append(cnt).append("\n");
    }

    static void dfs(int startY, int startX) {
        visit[startY][startX] = true;

        for(int drct = 0; drct < 4; drct++) {
            int ny = startY + DY[drct];
            int nx = startX + DX[drct];

            if(!canMove(ny, nx) || visit[ny][nx]) continue;

            if(board[ny].charAt(nx) == SHEEP) {
                dfs(ny, nx);
            }
        }
    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < h && x >= 0 && x < w;
    }
}