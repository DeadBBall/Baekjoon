import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static final int[] DY = {1, -1, 0, 0};
    static final int[] DX = {0, 0, 1, -1};
    static final char JIHOON = 'J';
    static final char FIRE = 'F';
    static final char WALL = '#';
    static Position jihoonStart;
    static List<Position> firePosition;
    static PriorityQueue<Position> fireQueue;
    static PriorityQueue<Position> jihoonQueue;
    static int ySize, xSize, ans;
    static char[][] board;
    static boolean[][] visit;

    public static void main(String[] args) {
        input();
        escapeMaze();
        System.out.println(ans == 0 ? "IMPOSSIBLE" : ans);
    }

    static void input() {
        ySize = sc.nextInt();
        xSize = sc.nextInt();
        board = new char[ySize][xSize];
        firePosition = new ArrayList<>();
        visit = new boolean[ySize][xSize];

        for(int y = 0; y < ySize; y++) {
            String input = sc.next();
            for(int x = 0; x < xSize; x++) {
                board[y][x] = input.charAt(x);
                if(board[y][x] == JIHOON) {
                    jihoonStart = new Position(y, x, 0);
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

        jihoonQueue = new PriorityQueue<>(new Comparator<Position>() {
            @Override
            public int compare(Position o1, Position o2) {
                return o1.time - o2.time;
            }
        });
    }

    static void escapeMaze() {
        jihoonQueue.add(jihoonStart);
        firePosition.forEach(fire -> fireQueue.add(fire));
        int nowTime = 0;

        while(!jihoonQueue.isEmpty()) {
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
        while(!jihoonQueue.isEmpty()) {
            Position nowJihoon = jihoonQueue.remove();
//            System.out.println(nowJihoon.time + " " + nowJihoon.y + " " + nowJihoon.x);
            if(canEscape(nowJihoon.y, nowJihoon.x)) {
                ans = nowJihoon.time + 1;
                return;
            }
            if(nowJihoon.time != time) {
                jihoonQueue.add(nowJihoon);
                return;
            }
            for(int dir = 0; dir < 4; dir++) {
                int ny = nowJihoon.y + DY[dir];
                int nx = nowJihoon.x + DX[dir];
                if(!canMove(ny, nx) || visit[ny][nx]) continue;
                visit[ny][nx] = true;
                jihoonQueue.add(new Position(ny, nx, time + 1));
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