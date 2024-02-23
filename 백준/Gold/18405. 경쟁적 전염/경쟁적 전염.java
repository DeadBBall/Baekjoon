import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static final int[] DY = {1, -1, 0, 0};
    static final int[] DX = {0, 0, 1, -1};
    static int n, k, s, targetY, targetX;
    static int[][] board;
    static PriorityQueue<Virus> viruses;

    public static void main(String[] args) {
        input();
        checkViruses();
        System.out.println(board[targetY - 1][targetX - 1]);
    }

    static void input() {
        n = sc.nextInt();
        k = sc.nextInt();
        
        viruses = new PriorityQueue<>(new Comparator<Virus>() {
            @Override
            public int compare(Virus o1, Virus o2) {
                if(o1.time == o2.time) {
                    return o1.num - o2.num;
                }
                return o1.time - o2.time;
            }
        });

        board = new int[n][n];

        for(int y = 0; y < n; y++) {
            for(int x = 0; x < n; x++) {
                board[y][x] = sc.nextInt();

                if(board[y][x] > 0) {
                    viruses.add(new Virus(y, x, board[y][x], 1));
                }
            }
        }

        s = sc.nextInt();
        targetY = sc.nextInt();
        targetX = sc.nextInt();
    }

    static void checkViruses() {
        while(!viruses.isEmpty()) {
            Virus now = viruses.remove();

            if(now.time > s) break;

            for(int drct = 0; drct < 4; drct++) {
                int ny = now.y + DY[drct];
                int nx = now.x + DX[drct];

                if(!canMove(ny, nx)) continue;

                board[ny][nx] = now.num;

                viruses.add(new Virus(ny, nx, board[ny][nx], now.time + 1));
            }

        }
    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n && board[y][x] == 0;
    }
}

class Virus {
    int y;
    int x;
    int num;
    int time;

    public Virus(int y, int x, int num, int time) {
        this.y = y;
        this.x = x;
        this.num = num;
        this.time = time;
    }
}