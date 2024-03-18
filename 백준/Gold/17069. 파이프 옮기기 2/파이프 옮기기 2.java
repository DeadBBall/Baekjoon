import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static final int EMPTY = 0;
    static final int RIGHT = 2;
    static final int DIAGONAL = 3;
    static final int DOWN = 4;
    static final int[] DY = {0, 1, 1};
    static final int[] DX = {1, 1, 0};
    static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[][] board;
    static long[][][] dp;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(movePipe(0, 1, RIGHT));
    }

    static void input() throws IOException {
//        n = Integer.parseInt(br.readLine());
        n = sc.nextInt();
        dp = new long[n][n][3];
        board = new int[n][n];

        for(int y = 0; y < n; y++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int x = 0; x < n; x++) {
//                board[y][x] = Integer.parseInt(st.nextToken());
                board[y][x] = sc.nextInt();
            }
        }
    }

    static long movePipe(int y, int x, int drct) {
        if(y == n - 1 && x == n - 1) return 1;

        if(dp[y][x][drct - 2] != 0) return dp[y][x][drct - 2];

        for(int dir = 0; dir < 3; dir++) {
            if(dir + 2 == RIGHT && drct == DOWN) continue;
            if(dir + 2 == DOWN && drct == RIGHT) continue;

            int ny = y + DY[dir];
            int nx = x + DX[dir];

            if(!canMove(ny, nx)) continue;

            if(dir + 2 == DIAGONAL && !canMoveDiagonal(ny, nx)) continue;

            dp[y][x][drct - 2] += movePipe(ny, nx, dir + 2);
        }

        return dp[y][x][drct - 2];
    }

    static boolean canMove(int y, int x) {
        return x >= 0 && x < n && y >= 0 && y < n && board[y][x] == EMPTY;
    }

    static boolean canMoveDiagonal(int y, int x) {
        return canMove(y, x) && board[y - 1][x] == EMPTY && board[y][x - 1] == EMPTY;
    }

}