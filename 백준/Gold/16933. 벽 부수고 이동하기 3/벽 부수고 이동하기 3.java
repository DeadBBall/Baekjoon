import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static final int[] DY = {1, -1, 0, 0};
    static final int[] DX = {0, 0, 1, -1};
    static Scanner sc = new Scanner(System.in);
    static int n, m, k;
    static boolean[][] board;
    static boolean[][][] visit;

    public static void main(String[] args) {
        input();
        System.out.println(move());
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        visit = new boolean[k + 1][n][m];
        board = new boolean[n][m];

        for(int y = 0; y < n; y++) {
            String inputBoard = sc.next();

            for(int x = 0; x < m; x++) {
                board[y][x] = inputBoard.charAt(x) == '1';
            }
        }
    }

    static int move() {
        if(n * m == 1) return 1;

        PriorityQueue<Position> positions = new PriorityQueue<>(new Comparator<Position>() {
            @Override
            public int compare(Position o1, Position o2) {
                return o1.time - o2.time;
            }
        });

        positions.add(new Position(0, 0, 1, 0));
        visit[0][0][0] = true;

        while(!positions.isEmpty()) {
            Position now = positions.remove();

            for(int drct = 0; drct < 4; drct++) {
                int ny = now.y + DY[drct];
                int nx = now.x + DX[drct];

                if(!canMove(ny, nx)) continue;

                if(ny == n - 1 && nx == m - 1) return now.time + 1;

                if(board[ny][nx]) {
                    if(now.brokenCount < k && !visit[now.brokenCount + 1][ny][nx]) {
                        visit[now.brokenCount + 1][ny][nx] = true;

                        if(now.time % 2 == 0) {
                            positions.add(new Position(ny, nx, now.time + 2, now.brokenCount + 1));
                        } else {
                            positions.add(new Position(ny, nx, now.time + 1, now.brokenCount + 1));
                        }
                    }
                } else {
                    if(!visit[now.brokenCount][ny][nx]) {
                        visit[now.brokenCount][ny][nx] = true;
                        positions.add(new Position(ny, nx, now.time + 1, now.brokenCount));
                    }
                }
            }

        }

        return -1;
    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }

}

class Position {
    int y;
    int x;
    int time;
    int brokenCount;

    public Position(int y, int x, int time, int brokenCount) {
        this.y = y;
        this.x = x;
        this.time = time;
        this.brokenCount = brokenCount;
    }
}