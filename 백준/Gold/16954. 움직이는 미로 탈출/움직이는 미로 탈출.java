import java.util.*;

public class Main {
    static final int BOARD_SIZE = 8;
    static final char EMPTY = '.';
    static final char WALL = '#';
    static final int[] DY = {1, -1, 0, 0, 1, 1, -1, -1, 0};
    static final int[] DX = {0, 0, 1, -1, 1, -1, 1, -1, 0};
    static Scanner sc = new Scanner(System.in);
    static char[][] board;
    static Queue<Integer> wallQueue;

    public static void main(String[] args) {
        input();
        System.out.println(escapeMaze() ? 1 : 0);
    }

    static void input() {
        board = new char[BOARD_SIZE][BOARD_SIZE];

        wallQueue = new LinkedList<>();

        for(int y = 0; y < BOARD_SIZE; y++) {
            String inputBoard = sc.next();

            for(int x = 0; x < BOARD_SIZE; x++) {
                board[y][x] = inputBoard.charAt(x);
            }
        }

        for(int y = BOARD_SIZE - 1; y >= 0; y--) {
            for(int x = 0; x < BOARD_SIZE; x++) {
                if(board[y][x] == WALL) {
                    wallQueue.add(y * 8 + x);
                }
            }
        }
    }

    static boolean escapeMaze() {
        Queue<Integer> posQueue = new LinkedList<>();
        posQueue.add(7 * 8);

        int time = 0;

        boolean[][][] visit = new boolean[BOARD_SIZE][BOARD_SIZE][BOARD_SIZE * BOARD_SIZE + 1];
        visit[7][0][time] = true;

        while(!posQueue.isEmpty()) {
            int size = posQueue.size();

            for(int idx = 0; idx < size; idx++) {
                int now = posQueue.remove();

                for (int drct = 0; drct < 9; drct++) {
                    int ny = now / 8 + DY[drct];
                    int nx = now % 8 + DX[drct];

                    if(!canMove(ny, nx) || visit[ny][nx][time + 1]) continue;

                    visit[ny][nx][time + 1] = true;

                    if(ny == 0 && nx == BOARD_SIZE - 1) return true;

                    posQueue.add(ny * 8 + nx);
                }
            }

            int wallSize = wallQueue.size();

            for(int idx = 0; idx < wallSize; idx++) {
                int wall = wallQueue.remove();
                int y = wall / 8;
                int x = wall % 8;

                board[y][x] = EMPTY;

                if(y < 7) {
                    board[y + 1][x] = WALL;
                    wallQueue.add((y + 1) * 8 + x);
                }
            }

            time++;
        }

        return false;
    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < BOARD_SIZE && x >= 0 && x < BOARD_SIZE
                && board[y][x] == EMPTY && (y - 1 < 0 || board[y - 1][x] == EMPTY);
    }

}