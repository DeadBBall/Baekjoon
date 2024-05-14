import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static final int[] DY = {1, -1, 0, 0, 0, 0, 0, -1, 0, 1};
    static final int[] DX = {0, 0, 1, -1, -1, 0, 1, 0, 0, 0};
    static final char LOG = 'B';
    static final char TARGET = 'E';
    static final char EMPTY = '0';
    static final char TREE = '1';
    static Scanner sc = new Scanner(System.in);
    static int n;
    static char[][] board;
    static boolean[][][] visit;
    static Log start;

    public static void main(String[] args) {
        input();
        System.out.println(rollLog());
    }

    static void input() {
        n = sc.nextInt();
        board = new char[n][n];
        visit = new boolean[n][n][2];

        for(int y = 0; y < n; y++) {
            String boardInput = sc.next();

            for(int x = 0; x < n; x++) {
                board[y][x] = boardInput.charAt(x);
            }
        }

        for(int y = 0; y < n; y++) {
            for(int x = 0; x < n; x++) {
                if(board[y][x] == LOG) {
                    if(x != n - 1 && board[y][x + 1] == LOG) {
                        start = new Log(y, x + 1, 0, 0);
                        board[y][x] = board[y][x + 1] = board[y][x + 2] = EMPTY;
                        visit[y][x + 1][0] = true;
                    }
                    else {
                        start = new Log(y + 1, x, 1, 0);
                        board[y][x] = board[y + 1][x] = board[y + 2][x] = EMPTY;
                        visit[y + 1][x][1] = true;
                    }
                    return;
                }
            }
        }
    }

    static int rollLog() {
        Queue<Log> logs = new LinkedList<>();
        logs.add(start);

        while(!logs.isEmpty()) {
            Log now = logs.remove();

            for(int drct = 0; drct < 4; drct++) {
                int ny = now.y + DY[drct];
                int nx = now.x + DX[drct];

                if(!canMove(ny, nx, now.drct)) continue;

                if(visit[ny][nx][now.drct]) continue;

                visit[ny][nx][now.drct] = true;

                if(isSuccess(now, ny, nx)) return now.moveCnt + 1;

                logs.add(new Log(ny, nx, now.drct, now.moveCnt + 1));
            }

            if(!canLotate(now.y, now.x)) continue;

            now.drct = (now.drct + 1) % 2;

            if(visit[now.y][now.x][now.drct]) continue;

            visit[now.y][now.x][now.drct] = true;

            now.moveCnt++;

            if(isSuccess(now, now.y, now.x)) return now.moveCnt;

            logs.add(now);
        }

        return 0;
    }

    static boolean canMove(int y, int x, int logDrct) {
        if (logDrct == 0) {
            return y >= 0 && y < n && x > 0 && x < n - 1 &&
                    board[y][x - 1] != TREE && board[y][x] != TREE && board[y][x + 1] != TREE;
        } else {
            return y > 0 && y < n - 1 && x >= 0 && x < n &&
                    board[y - 1][x] != TREE && board[y][x] != TREE && board[y + 1][x] != TREE;
        }
    }

    static boolean isSuccess(Log now, int y, int x) {
        for(int logDrct = 4 + now.drct * 3; logDrct < 7 + now.drct * 3; logDrct++) {
            if(board[y + DY[logDrct]][x + DX[logDrct]] != TARGET) return false;
        }

        return true;
    }


    static boolean canLotate(int yNow, int xNow) {
        if(!(yNow > 0 && yNow < n - 1 && xNow > 0 && xNow < n - 1)) return false;

        for(int y = yNow - 1; y <= yNow + 1; y++) {
            for(int x = xNow - 1; x <= xNow + 1; x++) {
                if(board[y][x] == TREE) return false;
            }
        }

        return true;
    }
}

class Log {
    int y;
    int x;
    int drct;
    int moveCnt;

    Log(int y, int x, int drct, int moveCnt) {
        this.y = y;
        this.x = x;
        this.drct = drct;
        this.moveCnt = moveCnt;
    }
}