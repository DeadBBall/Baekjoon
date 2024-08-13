import java.util.*;

public class Main {
    static final int[] DY = {0, 1, 0, -1};
    static final int[] DX = {1, 0, -1, 0};
    static Scanner sc = new Scanner(System.in);
    static int n, m, fuel;
    static boolean[][] board;

    public static void main(String[] args) {
        input();
        System.out.println(searchTarget());
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        fuel = sc.nextInt();
        board = new boolean[n][n];

        for(int y = 0; y < n; y++) {
            for(int x = 0; x < n; x++) {
                board[y][x] = sc.nextInt() == 1;
            }
        }
    }

    static int searchTarget() {
        Position start = new Position(sc.nextInt() - 1, sc.nextInt() - 1, 0);
        List<Position[]> targets = new ArrayList<>();

        for(int targetIdx = 0; targetIdx < m; targetIdx++) {
            Position[] target = new Position[2];

            for(int idx = 0; idx < 2; idx++) {
                target[idx] = new Position(sc.nextInt() - 1, sc.nextInt() - 1, 0);
            }

            targets.add(target);
        }

        Position now = start;

        while(!targets.isEmpty()) {
            int targetIdx = 0;
            int minDist = Integer.MAX_VALUE;

            for(int idx = 0; idx < targets.size(); idx++) {
                Position[] target = targets.get(idx);

                int dist = measureDist(now, target[0], minDist);

                if(dist < minDist) {
                    minDist = dist;
                    targetIdx = idx;
                } else if(dist == minDist) {
                    if(target[0].y < targets.get(targetIdx)[0].y) {
                        targetIdx = idx;
                    } else if(target[0].y == targets.get(targetIdx)[0].y &&
                            target[0].x < targets.get(targetIdx)[0].x) {
                        targetIdx = idx;
                    }
                }
            }

            if(minDist == Integer.MAX_VALUE || minDist > fuel) return -1;

            fuel -= minDist;

            Position[] target = targets.get(targetIdx);

            int endDist = measureDist(target[0], target[1], fuel);

            if(endDist == Integer.MAX_VALUE) return -1;

            fuel += endDist;

            now = target[1];

            targets.remove(targetIdx);
        }

        return fuel;
    }

    static int measureDist(Position start, Position end, int max) {
        Queue<Position> positions = new LinkedList<>();
        positions.add(start);

        boolean[][] visit = new boolean[n][n];
        visit[start.y][start.x] = true;

        while(!positions.isEmpty()) {
            Position now = positions.remove();

            if(max < now.cnt) return Integer.MAX_VALUE;

            if(now.y == end.y && now.x == end.x) return now.cnt;
            
            for(int drct = 0; drct < 4; drct++) {
                int ny = now.y + DY[drct];
                int nx = now.x + DX[drct];

                if(!canMove(ny, nx) || visit[ny][nx]) continue;

                visit[ny][nx] = true;

                positions.add(new Position(ny, nx, now.cnt + 1));
            }
        }

        return Integer.MAX_VALUE;
    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n && !board[y][x];
    }

}

class Position {
    int y;
    int x;
    int cnt;

    public Position(int y, int x, int cnt) {
        this.y = y;
        this.x = x;
        this.cnt = cnt;
    }
}