import java.util.*;

public class Main {
    static final int[] DY = {1, -1, 0, 0};
    static final int[] DX = {0, 0, 1, -1};
    static Scanner sc = new Scanner(System.in);
    static int n, m, ans;
    static Position minsik;
    static char[][] board;

    public static void main(String[] args) {
        input();
        escapeMaze();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        board = new char[n][m];

        for(int y = 0; y < n; y++) {
            String boardInput = sc.next();

            for(int x = 0; x < m; x++) {
                board[y][x] = boardInput.charAt(x);

                if(board[y][x] == '0') {
                    minsik = new Position(y, x, 0, 0);
                    board[y][x] = '.';
                }
            }
        }

        ans = -1;
    }

    static void escapeMaze() {
        boolean[][][] visit = new boolean[n][m][1 << 6];
        visit[minsik.y][minsik.x][minsik.keys] = true;

        Queue<Position> positionQueue = new LinkedList<>();
        positionQueue.add(minsik);

        while(!positionQueue.isEmpty()) {
            Position now = positionQueue.remove();

            for(int drct = 0; drct < 4; drct++) {
                int ny = now.y + DY[drct];
                int nx = now.x + DX[drct];
                int nKeys = now.keys;

                if(!canMove(ny, nx)) continue;

                if(board[ny][nx] >= 'a' && board[ny][nx] <= 'f') {
                    nKeys |= (1 << board[ny][nx] - 'a');
                }
                else if(board[ny][nx] >= 'A' && board[ny][nx] <= 'F') {
                    int bit = 1 << board[ny][nx] - 'A';

                    if((nKeys & bit) != bit) continue;
                }
                else if(board[ny][nx] == '1') {
                    ans = now.moveCnt + 1;
                    return;
                }

                if(visit[ny][nx][nKeys]) continue;

                visit[ny][nx][nKeys] = true;

                positionQueue.add(new Position(ny, nx, now.moveCnt + 1, nKeys));
            }
        }

    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m && board[y][x] != '#';
    }
}

class Position {
    int y;
    int x;
    int moveCnt;
    int keys;

    public Position(int y, int x, int moveCnt, int keys) {
        this.y = y;
        this.x = x;
        this.moveCnt = moveCnt;
        this.keys = keys;
    }
}