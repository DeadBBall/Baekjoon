import java.util.*;

public class Main {
    static final int[] DY = {1, 0};
    static final int[] DX = {0, 1};
    static Scanner sc = new Scanner(System.in);
    static int n;
    static char[][] board;
    static int[][] maxDp, minDp;

    public static void main(String[] args) {
        input();
        calculate();
        System.out.println(maxDp[n - 1][n - 1] + " " + minDp[n - 1][n - 1]);
    }

    static void input() {
        n = sc.nextInt();
        board = new char[n][n];

        for(int y = 0; y < n; y++) {
            for(int x = 0; x < n; x++) {
                board[y][x] = sc.next().charAt(0);
            }
        }

        maxDp = new int[n][n];
        minDp = new int[n][n];

        for(int y = 0; y < n; y++) {
            Arrays.fill(maxDp[y], Integer.MIN_VALUE);
            Arrays.fill(minDp[y], Integer.MAX_VALUE);
        }

        maxDp[0][0] = minDp[0][0] = board[0][0] - '0';
    }

    static void calculate() {
        dfs(0, 0, 0);
        dfs(0, 0, 1);
    }

    static void dfs(int nowY, int nowX, int type) {
        if(nowY == n - 1 && nowX == n - 1) return;

        for(int drct = 0; drct < 2; drct++) {
            int ny = nowY + DY[drct];
            int nx = nowX + DX[drct];

            if (!canMove(ny, nx)) continue;

            for(int nDrct = 0; nDrct < 2; nDrct++) {
                int nny = ny + DY[nDrct];
                int nnx = nx + DX[nDrct];

                if(!canMove(nny, nnx)) continue;

                if (type == 0) {
                    if (board[ny][nx] == '+') {
                        if (maxDp[nny][nnx] < maxDp[nowY][nowX] + (board[nny][nnx] - '0')) {
                            maxDp[nny][nnx] = maxDp[nowY][nowX] + (board[nny][nnx] - '0');

                            dfs(nny, nnx, type);
                        }
                    } else if (board[ny][nx] == '-') {
                        if (maxDp[nny][nnx] < maxDp[nowY][nowX] - (board[nny][nnx] - '0')) {
                            maxDp[nny][nnx] = maxDp[nowY][nowX] - (board[nny][nnx] - '0');

                            dfs(nny, nnx, type);
                        }
                    } else {
                        if (maxDp[nny][nnx] < maxDp[nowY][nowX] * (board[nny][nnx] - '0')) {
                            maxDp[nny][nnx] = maxDp[nowY][nowX] * (board[nny][nnx] - '0');

                            dfs(nny, nnx, type);
                        }
                    }
                } else {
                    if (board[ny][nx] == '+') {
                        if (minDp[nny][nnx] > minDp[nowY][nowX] + (board[nny][nnx] - '0')) {
                            minDp[nny][nnx] = minDp[nowY][nowX] + (board[nny][nnx] - '0');

                            dfs(nny, nnx, type);
                        }
                    } else if (board[ny][nx] == '-') {
                        if (minDp[nny][nnx] > minDp[nowY][nowX] - (board[nny][nnx] - '0')) {
                            minDp[nny][nnx] = minDp[nowY][nowX] - (board[nny][nnx] - '0');

                            dfs(nny, nnx, type);
                        }
                    } else {
                        if (minDp[nny][nnx] > minDp[nowY][nowX] * (board[nny][nnx] - '0')) {
                            minDp[nny][nnx] = minDp[nowY][nowX] * (board[nny][nnx] - '0');

                            dfs(nny, nnx, type);
                        }
                    }
                }
            }
        }
    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
}