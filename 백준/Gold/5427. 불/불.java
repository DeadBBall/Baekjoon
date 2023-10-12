import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static final int[] DY = {1, -1, 0, 0};
    static final int[] DX = {0, 0, 1, -1};
    static final char SANGEUN = '@';
    static final char FIRE = '*';
    static final char WALL = '#';
    static int t;
    static Position sangeunStart;
    static List<Position> firePosition;
    static PriorityQueue<Position> fireQueue;
    static PriorityQueue<Position> sangeunQueue;
    static int ySize, xSize, ans;
    static char[][] board;
    static boolean[][] visit;
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {
        t = sc.nextInt();
        while(t-- > 0) {
            input();
            escapeMaze();
            ansMaker.append(ans == 0 ? "IMPOSSIBLE" : ans).append("\n");
        }
        System.out.println(ansMaker);
    }

    static void input() {
        xSize = sc.nextInt();
        ySize = sc.nextInt();
        board = new char[ySize][xSize];
        firePosition = new ArrayList<>();
        visit = new boolean[ySize][xSize];
        ans = 0;

        for(int y = 0; y < ySize; y++) {
            String input = sc.next();
            for(int x = 0; x < xSize; x++) {
                board[y][x] = input.charAt(x);
                if(board[y][x] == SANGEUN) {
                    sangeunStart = new Position(y, x, 0);
                    board[y][x] = '.';
                    visit[y][x] = true;
                }
                else if(board[y][x] == FIRE)
                    firePosition.add(new Position(y, x, 0));
            }
        }

        fireQueue = new PriorityQueue<>(new Comparator<Position>() {
            @Override
            public int compare(Position o1, Position o2) {
                return o1.time - o2.time;
            }
        });

        sangeunQueue = new PriorityQueue<>(new Comparator<Position>() {
            @Override
            public int compare(Position o1, Position o2) {
                return o1.time - o2.time;
            }
        });
    }

    static void escapeMaze() {
        sangeunQueue.add(sangeunStart);
        firePosition.forEach(fire -> fireQueue.add(fire));
        int nowTime = 0;

        while(!sangeunQueue.isEmpty()) {
            fireMove(nowTime);
            jihoonMove(nowTime);
            nowTime++;
            if(ans != 0) return;
        }
    }

    static boolean canEscape(int y, int x) {
        return y == 0 || x == 0 || y == ySize - 1 || x == xSize - 1;
    }

    static void fireMove(int time) {
        while(!fireQueue.isEmpty()) {
            Position nowFire = fireQueue.remove();
            if(nowFire.time != time) {
                fireQueue.add(nowFire);
                return;
            }
            for(int dir = 0; dir < 4; dir++) {
                int ny = nowFire.y + DY[dir];
                int nx = nowFire.x + DX[dir];
                if(!canMove(ny, nx)) continue;
                board[ny][nx] = FIRE;
                fireQueue.add(new Position(ny, nx, time + 1));
            }
        }
    }

    static boolean canMove(int y, int x) {
        return !(y < 0 || x < 0 || y >= ySize || x >= xSize ||
                board[y][x] == FIRE || board[y][x] == WALL);
    }

    static void jihoonMove(int time) {
        while(!sangeunQueue.isEmpty()) {
            Position nowJihoon = sangeunQueue.remove();
            if(canEscape(nowJihoon.y, nowJihoon.x)) {
                ans = nowJihoon.time + 1;
                return;
            }
            if(nowJihoon.time != time) {
                sangeunQueue.add(nowJihoon);
                return;
            }
            for(int dir = 0; dir < 4; dir++) {
                int ny = nowJihoon.y + DY[dir];
                int nx = nowJihoon.x + DX[dir];
                if(!canMove(ny, nx) || visit[ny][nx]) continue;
                visit[ny][nx] = true;
                sangeunQueue.add(new Position(ny, nx, time + 1));
            }
        }
    }

    static class Position {
        int y;
        int x;
        int time;

        public Position(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }

}