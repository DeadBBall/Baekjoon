import java.util.*;

public class Main {
    static final int WALL = 1;
    static final int[] DY = {1, -1, 0, 0};
    static final int[] DX = {0, 0, 1, -1};
    static Scanner sc = new Scanner(System.in);
    static int r, c, minTime, posCnt;
    static int[][][] board;
    static Position[] villains;

    public static void main(String[] args) {
        input();
        move();
        System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime + "\n" + posCnt);
    }

    static void input() {
        r = sc.nextInt();
        c = sc.nextInt();
        board = new int[r][c][4];

        for(int y = 0; y < r; y++) {
            String line = sc.next();

            for(int x = 0; x < c; x++) {
                Arrays.fill(board[y][x], -1);
                board[y][x][0] = line.charAt(x) - '0';
            }
        }

        villains = new Position[3];

        for(int idx = 0; idx < 3; idx++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            villains[idx] = new Position(x - 1, y - 1);
        }

        minTime = Integer.MAX_VALUE;
    }

    static void move() {
        for(int idx = 0; idx < 3; idx++) {
            Queue<Position> positions = new LinkedList<>();

            positions.add(villains[idx]);

            board[villains[idx].y][villains[idx].x][idx + 1] = 0;

            while(!positions.isEmpty()) {
                Position now = positions.remove();

                for(int drct = 0; drct < 4; drct++) {
                    int ny = now.y + DY[drct];
                    int nx = now.x + DX[drct];

                    if(!canMove(ny, nx)) continue;

                    if(board[ny][nx][idx + 1] != -1) continue;

                    board[ny][nx][idx + 1] = board[now.y][now.x][idx + 1] + 1;

                    positions.add(new Position(ny, nx));
                }
            }
        }

        for(int y = 0; y < r; y++) {
            for(int x = 0; x < c; x++) {
                int maxTime = -1;

                for(int idx = 1; idx < 4; idx++) {
                    if(board[y][x][idx] == -1) {
                        maxTime = -1;
                        break;
                    }

                    maxTime = Math.max(maxTime, board[y][x][idx]);
                }

                if(maxTime == -1) continue;

                if(minTime > maxTime) {
                    minTime = maxTime;
                    posCnt = 1;
                } else if(minTime == maxTime) {
                    posCnt++;
                }
            }
        }
    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < r && x >= 0 && x < c && board[y][x][0] != WALL;
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