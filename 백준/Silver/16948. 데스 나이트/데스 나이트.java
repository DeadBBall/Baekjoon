import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static final int[] DY = {-2, -2, 0, 0, 2, 2};
    static final int[] DX = {-1, 1, -2, 2, -1, 1};
    static int n;
    static Position start;
    static Position target;
    static int ans;
    static boolean[][] visit;

    public static void main(String[] args) {
        input();
        moveDeathKnight();
        System.out.println(ans);
    }
    static void input() {
        n = sc.nextInt();
        visit = new boolean[n][n];
        ans = -1;

        start = new Position(sc.nextInt(), sc.nextInt(), 0);
        visit[start.y][start.x] = true;
        target = new Position(sc.nextInt(), sc.nextInt(), 0);
    }

    static void moveDeathKnight() {
        Queue<Position> positionQueue = new LinkedList<>();
        positionQueue.add(start);

        while(!positionQueue.isEmpty()) {
            Position now = positionQueue.remove();
            if(now.y == target.y && now.x == target.x) {
                ans = now.count;
                return;
            }
            for(int dir = 0; dir < 6; dir++) {
                int ny = now.y + DY[dir];
                int nx = now.x + DX[dir];
                if(!canMove(ny, nx)) continue;

                visit[ny][nx] = true;
                positionQueue.add(new Position(ny, nx, now.count + 1));
            }
        }
    }

    static boolean canMove(int y, int x) {
        return !(y < 0 || x < 0 || y >= n || x >= n || visit[y][x]);
    }

    static class Position {
        int y;
        int x;
        int count;

        public Position(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }

}