import java.util.*;

public class Main {
    static final int[] DY = {1, 0, -1};
    static final int[] DX = {0, 1, 0};
    static Scanner sc = new Scanner(System.in);
    static boolean[][] board;
    static int b, n, m, ans;
    static Staff[] staff;

    public static void main(String[] args) {
        input();
        pack();
        System.out.println(ans);
    }

    static void input() {
        b = sc.nextInt();
        n = sc.nextInt();
        m = sc.nextInt();

        board = new boolean[b][b];
        staff = new Staff[n];

        for(int idx = 0; idx < n; idx++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            int time = sc.nextInt();

            staff[idx] = new Staff(y, x, time, -time);
        }
    }

    static void pack() {
        int totalTime = m + b * 3 - 2;
        int nowTime = 0;

        while(nowTime < totalTime) {
            nowTime++;

            board[b - 1][0] = false;

            for(int x = 0; x < b - 1; x++) {
                board[b - 1][x] = board[b - 1][x + 1];
            }

            for(int y = b - 1; y > 0; y--) {
                board[y][b - 1] = board[y - 1][b - 1];
            }

            for(int x = b - 1; x > 0; x--) {
                board[0][x] = board[0][x - 1];
            }

            board[0][0] = false;

            if(nowTime <= m) {
                board[0][0] = true;
            }

            for(Staff now : staff) {
                for(int drct = 0; drct < 3; drct++) {
                    int ny = now.y + DY[drct];
                    int nx = now.x + DX[drct];

                    if(!canMove(ny, nx)) continue;

                    if(now.startTime + now.time <= nowTime) {
                        now.startTime = nowTime;
                        board[ny][nx] = false;
                        ans++;
                    }
                }
            }
        }
    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < b && x >= 0 && x < b && board[y][x];
    }
}

class Staff {
    int y;
    int x;
    int time;
    int startTime;

    public Staff(int y, int x, int time, int startTime) {
        this.y = y;
        this.x = x;
        this.time = time;
        this.startTime = startTime;
    }
}
