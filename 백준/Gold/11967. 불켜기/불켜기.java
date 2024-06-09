import java.util.*;

public class Main {
    static final int START = 1;
    static final int ON = 1;
    static final int OFF = 0;
    static final int[] DY = {1, -1, 0, 0};
    static final int[] DX = {0, 0, 1, -1};
    static Scanner sc = new Scanner(System.in);
    static int n, m, ans;
    static boolean[][] board;
    static List<Position>[][] switches;

    public static void main(String[] args) {
        input();
        turnOn();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        board = new boolean[n + 1][n + 1];

        switches = new ArrayList[n + 1][n + 1];

        board[START][START] = true;
        ans = 1;

        while(m-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(switches[y][x] == null) {
                switches[y][x] = new ArrayList<>();
            }

            switches[y][x].add(new Position(b, a));
        }
    }

    static void turnOn() {
        Queue<Position> positionQueue = new LinkedList<>();
        positionQueue.add(new Position(START, START));

        boolean[][][] visit = new boolean[n + 1][n + 1][2];
        visit[START][START][ON] = true;

        while(!positionQueue.isEmpty()) {
            Position now = positionQueue.remove();

            if(switches[now.y][now.x] != null) {
                for(Position position : switches[now.y][now.x]) {
                    if(!board[position.y][position.x]) {
                        board[position.y][position.x] = true;
                        ans++;
                    }

                    if(visit[position.y][position.x][OFF]) {
                        positionQueue.add(position);
                    }
                }
                switches[now.y][now.x] = null;
            }

            for(int drct = 0; drct < 4; drct++) {
                int ny = now.y + DY[drct];
                int nx = now.x + DX[drct];

                if(!canMove(ny, nx) || visit[ny][nx][ON]) continue;

                if(!board[ny][nx]) {
                    visit[ny][nx][OFF] = true;
                    continue;
                }

                visit[ny][nx][ON] = true;

                positionQueue.add(new Position(ny, nx));
            }
        }
    }

    static boolean canMove(int y, int x) {
        return y >= 1 && y <= n && x >= 1 && x <= n;
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