import java.util.*;

public class Main {
    static final int[] DY = {0, 1, 0, -1};
    static final int[] DX = {1, 0, -1, 0};
    static Scanner sc = new Scanner(System.in);
    static int m, n, ans;
    static boolean[][] board;
    static boolean[][][] visit;

    public static void main(String[] args) {
        input();
        move();
        System.out.println(ans);
    }

    static void input() {
        m = sc.nextInt();
        n = sc.nextInt();

        board = new boolean[m + 1][n + 1];
        visit = new boolean[4][m + 1][n + 1];

        for(int y = 1; y <= m; y++) {
            for(int x = 1; x <= n; x++) {
                board[y][x] = sc.nextInt() == 1;
            }
        }
    }

    static void move() {
        PriorityQueue<Position> positions = new PriorityQueue<>(new Comparator<Position>() {
            @Override
            public int compare(Position o1, Position o2) {
                return o1.cnt - o2.cnt;
            }
        });

        Position start = new Position(sc.nextInt(), sc.nextInt(), 0, changeDrct(sc.nextInt()));
        Position target = new Position(sc.nextInt(), sc.nextInt(), 0, changeDrct(sc.nextInt()));

        positions.add(start);

        visit[start.drct][start.y][start.x] = true;

        while(!positions.isEmpty()) {
            Position now = positions.remove();

            if(now.y == target.y && now.x == target.x && now.drct == target.drct) {
                ans = now.cnt;
                return;
            }

            for(int dist = 1; dist <= 3; dist++) {
                int ny = now.y + DY[now.drct] * dist;
                int nx = now.x + DX[now.drct] * dist;

                if(!canMove(ny, nx)) break;

                if(visit[now.drct][ny][nx]) continue;

                visit[now.drct][ny][nx] = true;

                positions.add(new Position(ny, nx, now.cnt + 1, now.drct));
            }

            int nextDrct = (now.drct + 1) % 4;

            if(!visit[nextDrct][now.y][now.x]) {
                visit[nextDrct][now.y][now.x] = true;

                positions.add(new Position(now.y, now.x, now.cnt + 1, nextDrct));
            }

            nextDrct = (now.drct + 3) % 4;

            if(!visit[nextDrct][now.y][now.x]) {
                visit[nextDrct][now.y][now.x] = true;

                positions.add(new Position(now.y, now.x, now.cnt + 1, nextDrct));
            }
        }
    }

    static int changeDrct(int drct) {
        if(drct == 1) return 0;
        else if(drct == 2) return 2;
        else if(drct == 3) return 1;
        return 3;
    }

    static boolean canMove(int y, int x) {
        return y >= 1 && y <= m && x >= 1 && x <= n && !board[y][x];
    }

}

class Position {
    int y;
    int x;
    int cnt;
    int drct;

    public Position(int y, int x, int cnt, int drct) {
        this.y = y;
        this.x = x;
        this.cnt = cnt;
        this.drct = drct;
    }
}