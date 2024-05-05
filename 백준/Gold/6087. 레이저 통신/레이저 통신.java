import java.util.*;

public class Main {
    static final char WALL = '*';
    static final char EMPTY = '.';
    static final int[] DY = {1, 0, -1, 0};
    static final int[] DX = {0, 1, 0, -1};
    static Scanner sc = new Scanner(System.in);
    static int w, h, ans;
    static String[] board;
    static List<Laser> lasers;

    public static void main(String[] args) {
        input();
        communicate();
        System.out.println(ans);
    }

    static void input() {
        w = sc.nextInt();
        h = sc.nextInt();
        board = new String[h];
        lasers = new ArrayList<>();

        for(int y = 0; y < h; y++) {
            board[y] = sc.next();

            for(int x = 0; x < w; x++) {
                if(board[y].charAt(x) == 'C') {
                    lasers.add(new Laser(y, x, 0, 0));
                }
            }
        }
    }

    static void communicate() {
        PriorityQueue<Laser> priorityQueue = new PriorityQueue<>(new Comparator<Laser>() {
            @Override
            public int compare(Laser o1, Laser o2) {
                return o1.mirrorCnt - o2.mirrorCnt;
            }
        });

        for(int drct = 0; drct < 4; drct++) {
            Laser start = new Laser(lasers.get(0));
            start.drct = drct;
            priorityQueue.add(start);
        }

        boolean[][] visit = new boolean[h][w];

        while(!priorityQueue.isEmpty()) {
            Laser now = priorityQueue.remove();

            visit[now.y][now.x] = true;

            if(lasers.get(1).y == now.y && lasers.get(1).x == now.x) {
                ans = now.mirrorCnt;
                return;
            }

            for(int cnt = 0; cnt < 4; cnt++) {
                int drct = now.drct + cnt;

                if(cnt == 2) continue;

                drct %= 4;

                int ny = now.y + DY[drct];
                int nx = now.x + DX[drct];

                if (!canMove(ny, nx)) continue;

                if(visit[ny][nx]) continue;

                priorityQueue.add(new Laser(ny, nx, drct == now.drct ? now.mirrorCnt : now.mirrorCnt + 1, drct));
            }

        }

    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < h && x >= 0 && x < w && board[y].charAt(x) != WALL;
    }

}

class Laser {
    int y;
    int x;
    int mirrorCnt;
    int drct;

    public Laser(int y, int x, int mirrorCnt, int drct) {
        this.y = y;
        this.x = x;
        this.mirrorCnt = mirrorCnt;
        this.drct = drct;
    }

    public Laser(Laser laser) {
        this.y = laser.y;
        this.x = laser.x;
        this.mirrorCnt = laser.mirrorCnt;
        this.drct = laser.drct;
    }
}
