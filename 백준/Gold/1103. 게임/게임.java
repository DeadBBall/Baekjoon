import java.io.*;
import java.util.*;

public class Main {
    //    static final Scanner SC = new Scanner(System.in);
    static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder ansMaker = new StringBuilder();
    static final int[] DY = {1, -1, 0, 0};
    static final int[] DX = {0, 0, 1, -1};
    static final char HOLE = 'H';
    static final int START = 0;
    static int n, m, ans;
    static boolean[][] visit;
    static char[][] board;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        input();
        playGame();
        BW.write(ansMaker.toString());
        BW.flush();
    }
    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(BR.readLine());
        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());
        visit = new boolean[n][m];
        board = new char[n][m];
        dp = new int[n][m];

        for(int y = 0; y < n; y++) {
            String boardInput = BR.readLine();

            for(int x = 0; x < m; x++) {
                board[y][x] = boardInput.charAt(x);
            }
        }
    }

    static void playGame() {
        visit[START][START] = true;
        moveCoin(START, START, 0);
        ansMaker.append(ans);
    }

    static void moveCoin(int y, int x, int dist) {
        if(ans == -1) return;
        ans = Math.max(ans, dist + 1);

        int step = board[y][x] - '0';

        for(int drct = 0; drct < 4; drct++) {
            int ny = y + step * DY[drct];
            int nx = x + step * DX[drct];

            if(!canMove(ny, nx) || dp[ny][nx] >= dist + 1) continue;

            if(visit[ny][nx]) {
                ans = -1;
                return;
            }

            dp[ny][nx] = dist + 1;
            visit[ny][nx] = true;
            moveCoin(ny, nx, dist + 1);
            visit[ny][nx] = false;
        }

    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m && board[y][x] != HOLE;
    }
}
