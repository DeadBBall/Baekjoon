import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static final int[] DY = {-1, 1, 0, 0};
    static final int[] DX = {0, 0, -1, 1};
    static final char UP = 'U';
    static final char DOWN = 'D';
    static final char LEFT = 'L';
    static final char RIGHT = 'R';
    static Scanner sc = new Scanner(System.in);
    static int n, m, ans;
    static int[][] board;
    static int[][] visit;

    public static void main(String[] args) {
        input();
        checkAllZone();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];
        visit = new int[n][m];

        for(int y = 0; y < n; y++) {
            String boardInput = sc.next();

            for(int x = 0; x < m; x++) {
                char zone = boardInput.charAt(x);
                if(zone == DOWN) {
                    board[y][x] = 1;
                }
                else if(zone == LEFT) {
                    board[y][x] = 2;
                }
                else if(zone == RIGHT) {
                    board[y][x] = 3;
                }
            }
        }
    }

    static void checkAllZone() {
        int visitIdx = 1;

        for(int y = 0; y < n; y++) {
            for(int x = 0; x < m; x++) {
                if(visit[y][x] == 0) {
                    searchCycle(y, x, visitIdx++);
                }
            }
        }
    }

    static void searchCycle(int yStart, int xStart, int visitIdx) {
        ans++;

        Queue<Position> positionQueue = new LinkedList<>();
        positionQueue.add(new Position(yStart, xStart));
        visit[yStart][xStart] = visitIdx;

        while(!positionQueue.isEmpty()) {
            Position now = positionQueue.remove();

            int drct = board[now.y][now.x];

            int ny = now.y + DY[drct];
            int nx = now.x + DX[drct];

            if(visit[ny][nx] == 0) {
                visit[ny][nx] = visitIdx;
                positionQueue.add(new Position(ny, nx));
            }
            else if(visit[ny][nx] == visitIdx) break;
            else {
                ans--;
                break;
            }
        }
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