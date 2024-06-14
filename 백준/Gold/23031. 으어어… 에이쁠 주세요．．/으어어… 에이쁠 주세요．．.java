import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final int[] DY = {1, 0, -1, 0, 1, 1, -1, -1, 0};
    static final int[] DX = {0, 1, 0, -1, 1, -1, 1, -1, 0};
    static final char LIGHT = 'L';
    static final char ZOMBIE = 'Z';
    static final char SWITCH = 'S';
    static final char EMPTY = 'O';
    static final char FRONT = 'F';
    static final char LEFT = 'L';
    static Scanner sc = new Scanner(System.in);
    static int n;
    static String a;
    static char[][] board;
    static boolean[][] light;
    static List<Position> zombies;
    static Position ahri;

    public static void main(String[] args){
        input();
        System.out.println(move() ? "Phew..." : "Aaaaaah!");
    }

    static void input() {
        n = sc.nextInt();
        board = new char[n + 1][n + 1];
        a = sc.next();
        zombies = new ArrayList<>();
        light = new boolean[n + 1][n + 1];

        for(int y = 1; y <= n; y++) {
            String inputBoard = sc.next();

            for(int x = 1; x <= n; x++) {
                board[y][x] = inputBoard.charAt(x - 1);

                if(board[y][x] == ZOMBIE) {
                    board[y][x] = EMPTY;
                    zombies.add(new Position(y, x, 0));
                }
            }
        }

        ahri = new Position(1, 1, 0);
    }

    static boolean move() {
        for(int moveIdx = 0; moveIdx < a.length(); moveIdx++) {
            char now = a.charAt(moveIdx);

            if(now == FRONT) {
                int ny = ahri.y + DY[ahri.drct];
                int nx = ahri.x + DX[ahri.drct];

                if(canMove(ny, nx)) {
                    ahri.y = ny;
                    ahri.x = nx;

                    if(board[ny][nx] == SWITCH) {
                        for(int drct = 0; drct < 9; drct++) {
                            int ly = ny + DY[drct];
                            int lx = nx + DX[drct];

                            if(!canMove(ly, lx)) continue;

                            light[ly][lx] = true;
                        }
                    }
                }
            } else if(now == LEFT) {
                ahri.drct = (ahri.drct + 1) % 4;
            } else {
                ahri.drct = (ahri.drct + 3) % 4;
            }

            for(Position zombie : zombies) {
                if(!light[zombie.y][zombie.x] && zombie.y == ahri.y && zombie.x == ahri.x) return false;

                int ny = zombie.y + DY[zombie.drct];
                int nx = zombie.x + DX[zombie.drct];

                if(!canMove(ny, nx)) {
                    zombie.drct = (zombie.drct + 2) % 4;
                    continue;
                }

                zombie.y = ny;
                zombie.x = nx;

                if(light[ny][nx]) continue;

                if(ahri.y == ny && ahri.x == nx) return false;
            }
        }

        return true;
    }

    static boolean canMove(int y, int x) {
        return y >= 1 && y <= n && x >= 1 && x <= n;
    }

}

class Position {
    int y;
    int x;
    int drct;

    Position(int y, int x, int drct) {
        this.y = y;
        this.x = x;
        this.drct = drct;
    }
}