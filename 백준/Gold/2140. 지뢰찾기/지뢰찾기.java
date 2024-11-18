import java.util.*;

public class Main {
    static final char EMPTY = '-';
    static final char MINE = '*';
    static final char CLOSE = '#';
    static final int[] DY = {1, 1, 1, -1, -1, -1, 0, 0};
    static final int[] DX = {1, -1, 0, 1, -1, 0, 1, -1};
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static char[][] board;

    public static void main(String[] args) {
        input();
        findMine();
        System.out.println(ans);
    }


    static void input() {
        n = sc.nextInt();
        board = new char[n][n];

        for(int y = 0; y < n; y++) {
            String inputStr = sc.next();

            for(int x = 0; x < n; x++) {
                board[y][x] = inputStr.charAt(x);
            }
        }

        ans = n >= 5 ? (n - 4) * (n - 4) : 0;
    }

    static void findMine() {
        for(int x = 0; x < n - 1; x++) {
            if(board[0][x] == '0') {
                changeToEmpty(0, x);
                continue;
            }

            int mineCnt = countMine(0, x);

            for(int drct = 0; drct < 3; drct++) {
                int ny = DY[drct];
                int nx = x + DX[drct];

                if(!canMove(ny, nx)) continue;

                if(board[ny][nx] == CLOSE) {
                    if(mineCnt == board[0][x] - '0') {
                        board[ny][nx] = EMPTY;
                    } else {
                        board[ny][nx] = MINE;
                        ans++;
                    }
                }
            }
        }

        for(int y = 0; y < n - 1; y++) {
            if(board[y][n - 1] == '0') {
                changeToEmpty(y, n - 1);
                continue;
            }

            int mineCnt = countMine(y, n - 1);

            for(int drct = 1; drct < 8; drct += 3) {
                int ny = y + DY[drct];
                int nx = n - 1 + DX[drct];

                if(!canMove(ny, nx)) continue;

                if(board[ny][nx] == CLOSE) {
                    if(mineCnt == board[y][n - 1] - '0') {
                        board[ny][nx] = EMPTY;
                    } else {
                        board[ny][nx] = MINE;
                        ans++;
                    }
                }
            }
        }

        for(int x = n - 1; x >= 0; x--) {
            if(board[n - 1][x] == '0') {
                changeToEmpty(n - 1, x);
                continue;
            }

            int mineCnt = countMine(n - 1, x);

            for(int drct = 3; drct < 6; drct++) {
                int ny = n - 1 + DY[drct];
                int nx = x + DX[drct];

                if(!canMove(ny, nx)) continue;

                if(board[ny][nx] == CLOSE) {
                    if(mineCnt == board[n - 1][x] - '0') {
                        board[ny][nx] = EMPTY;
                    } else {
                        board[ny][nx] = MINE;
                        ans++;
                    }
                }
            }
        }

        for(int y = n - 1; y >= 0; y--) {
            if(board[y][0] == '0') {
                changeToEmpty(y, 0);
                continue;
            }

            int mineCnt = countMine(y, 0);

            for(int drct = 0; drct < 8; drct += 3) {
                int ny = y + DY[drct];
                int nx = DX[drct];

                if(!canMove(ny, nx)) continue;

                if(board[ny][nx] == CLOSE) {
                    if(mineCnt == board[y][0] - '0') {
                        board[ny][nx] = EMPTY;
                    } else {
                        board[ny][nx] = MINE;
                        ans++;
                    }
                }
            }
        }
    }

    static int countMine(int y, int x) {
        int cnt = 0;

        for(int drct = 0; drct < 8; drct++) {
            int ny = y + DY[drct];
            int nx = x + DX[drct];

            if(!canMove(ny, nx)) continue;

            if(board[ny][nx] == MINE) cnt++;
        }

        return cnt;
    }

    static void changeToEmpty(int y, int x) {
        for(int drct = 0; drct < 8; drct++) {
            int ny = y + DY[drct];
            int nx = x + DX[drct];

            if(!canMove(ny, nx) || board[ny][nx] != CLOSE) continue;

            board[ny][nx] = EMPTY;
        }
    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
}