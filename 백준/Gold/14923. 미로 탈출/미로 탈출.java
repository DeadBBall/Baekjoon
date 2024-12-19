import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static final int WALL = 1;
    static final int[] DY = {1, -1, 0, 0};
    static final int[] DX = {0, 0, 1, -1};
    static Scanner sc = new Scanner(System.in);
    static int n, m, hx, hy, ex, ey, ans;
    static int[][] board;

    public static void main(String[] args) {
        input();
        escapeMaze();
        System.out.println(ans == 0 ? -1 : ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        hy = sc.nextInt() - 1;
        hx = sc.nextInt() - 1;
        ey = sc.nextInt() - 1;
        ex = sc.nextInt() - 1;

        board = new int[n][m];

        for(int y = 0; y < n; y++) {
            for(int x = 0; x < m; x++) {
                board[y][x] = sc.nextInt();
            }
        }
    }

    static void escapeMaze() {
        int[][][] visit = new int[2][n][m];

        PriorityQueue<Position> positions = new PriorityQueue<>(new Comparator<Position>() {
            @Override
            public int compare(Position o1, Position o2) {
                return o1.cnt - o2.cnt;
            }
        });
        positions.add(new Position(hy, hx, 0, false));
        visit[0][hy][hx] = visit[1][hy][hx] = 1;

        while(!positions.isEmpty()) {
            Position now = positions.remove();

            for(int drct = 0; drct < 4; drct++) {
                int ny = now.y + DY[drct];
                int nx = now.x + DX[drct];

                if(!canMove(ny, nx)) continue;

                if(ny == ey && nx == ex) {
                    ans = now.cnt + 1;
                    return;
                }

                if(board[ny][nx] == WALL) {
                    if(!now.isStaffUsed && (visit[1][ny][nx] == 0 || visit[1][ny][nx] > now.cnt + 1)) {
                        positions.add(new Position(ny, nx, now.cnt + 1, true));
                        visit[1][ny][nx] = now.cnt + 1;
                    }

                    continue;
                }

                if(visit[now.isStaffUsed ? 1 : 0][ny][nx] <= now.cnt + 1
                        && visit[now.isStaffUsed ? 1 : 0][ny][nx] != 0) continue;

                visit[now.isStaffUsed ? 1: 0][ny][nx] = now.cnt + 1;
                positions.add(new Position(ny, nx, now.cnt + 1, now.isStaffUsed));
            }
        }
    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}

class Position {
    int y;
    int x;
    int cnt;
    boolean isStaffUsed;

    public Position(int y, int x, int cnt, boolean isStaffUsed) {
        this.y = y;
        this.x = x;
        this.cnt = cnt;
        this.isStaffUsed = isStaffUsed;
    }
}