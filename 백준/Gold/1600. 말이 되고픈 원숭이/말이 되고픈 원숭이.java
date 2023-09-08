import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static final int WALL = 1;
    static final int EMPTY = 0;
    static final int INF = 40001;
    static final int[] DY = {1, -1, 0, 0};
    static final int[] DX = {0, 0, 1, -1};
    static final int[] HORSEDY = {-2, -2, -1, -1, 1, 1, 2, 2};
    static final int[] HORSEDX = {-1, 1, -2, 2, 2, -2, 1, -1};
    static int k, w, h;
    static int[][] board;
    static boolean[][][] visit;
    static Point start;
    static Point end;
    static int minMoveCount;

    public static void main(String[] args) {
        input();
        travel();
        System.out.println(minMoveCount == INF ? -1 : minMoveCount);
    }

    static void input() {
       k = sc.nextInt();
       w = sc.nextInt();
       h = sc.nextInt();
       board = new int[h][w];
       visit = new boolean[h][w][k + 1];
       minMoveCount = INF;

       for(int y = 0; y < h; y++) {
           for(int x = 0; x < w; x++) {
               board[y][x] = sc.nextInt();
           }
       }

       start = new Point(0, 0, 0, 0);
       end = new Point(h - 1, w - 1, 0, 0);
    }

    static void travel() {
        PriorityQueue<Point> points = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.totalMoveCount - o2.totalMoveCount;
            }
        });
        points.add(start);
        visit[start.y][start.x][0] = true;

        while(!points.isEmpty()) {
            Point now = points.remove();

            if(now.y == end.y && now.x == end.x) {
                minMoveCount = now.totalMoveCount;
                return;
            }

            if(now.moveLikeHorseCount < k) {
                for (int drct = 0; drct < 8; drct++) {
                    int ny = now.y + HORSEDY[drct];
                    int nx = now.x + HORSEDX[drct];

                    if (!canMove(ny, nx, now.moveLikeHorseCount + 1)) continue;

                    visit[ny][nx][now.moveLikeHorseCount + 1] = true;
                    points.add(new Point(ny, nx, now.moveLikeHorseCount + 1, now.totalMoveCount + 1));
                }
            }

            for(int drct = 0; drct < 4; drct++) {
                int ny = now.y + DY[drct];
                int nx = now.x + DX[drct];

                if(!canMove(ny, nx, now.moveLikeHorseCount)) continue;

                visit[ny][nx][now.moveLikeHorseCount] = true;
                points.add(new Point(ny, nx, now.moveLikeHorseCount, now.totalMoveCount + 1));
            }

        }

    }

    static boolean canMove(int y, int x, int moveLikeHorseCount) {
        return !(y < 0 || x < 0 || y >= h || x >= w || visit[y][x][moveLikeHorseCount] || board[y][x] == WALL);
    }

    static class Point {
        int y;
        int x;
        int moveLikeHorseCount;
        int totalMoveCount;

        public Point(int y, int x, int moveLikeHorseCount, int totalMoveCount) {
            this.y = y;
            this.x = x;
            this.moveLikeHorseCount = moveLikeHorseCount;
            this.totalMoveCount = totalMoveCount;
        }
    }

}