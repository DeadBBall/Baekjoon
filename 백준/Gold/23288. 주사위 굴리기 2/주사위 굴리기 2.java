import java.util.*;

public class Main {
    static final int[] DY = {0, 1, 0, -1};
    static final int[] DX = {1, 0, -1, 0};
    static Scanner sc = new Scanner(System.in);
    static int n, m, k, ans;
    static int[][] board;
    static int[][] dice;

    public static void main(String[] args) {
        input();
        rollDice();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        board = new int[n][m];

        for(int y = 0; y < n; y++) {
            for(int x = 0; x < m; x++) {
                board[y][x] = sc.nextInt();
            }
        }

        dice = new int[4][3];

        dice[0][1] = 2;
        dice[1][0] = 4;
        dice[1][1] = 1;
        dice[1][2] = 3;
        dice[2][1] = 5;
        dice[3][1] = 6;
    }

    static void rollDice() {
        int nowDrct = 0;
        int x = 0;
        int y = 0;

        while(k-- > 0) {
            int ny = y + DY[nowDrct];
            int nx = x + DX[nowDrct];

            if(!canMove(ny, nx)) {
                nowDrct = (nowDrct + 2) % 4;
                ny = y + DY[nowDrct];
                nx = x + DX[nowDrct];
            }
            
            turnDice(nowDrct);

            int a = dice[3][1];

            if(board[ny][nx] < a) {
                nowDrct++;
            } else if(board[ny][nx] > a) {
                nowDrct += 3;
            }
            nowDrct %= 4;

            ans += board[ny][nx] * dfs(ny, nx, new boolean[n][m]);

            y = ny;
            x = nx;
        }
    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }

    static void turnDice(int drct) {
        if(drct == 0) {
            int tmp = dice[1][2];
            dice[1][2] = dice[1][1];
            dice[1][1] = dice[1][0];
            dice[1][0] = dice[3][1];
            dice[3][1] = tmp;
        } else if(drct == 1) {
            int tmp = dice[0][1];
            dice[0][1] = dice[3][1];
            dice[3][1] = dice[2][1];
            dice[2][1] = dice[1][1];
            dice[1][1] = tmp;
        } else if(drct == 2) {
            int tmp = dice[1][2];
            dice[1][2] = dice[3][1];
            dice[3][1] = dice[1][0];
            dice[1][0] = dice[1][1];
            dice[1][1] = tmp;
        } else {
            int tmp = dice[0][1];
            dice[0][1] = dice[1][1];
            dice[1][1] = dice[2][1];
            dice[2][1] = dice[3][1];
            dice[3][1] = tmp;
        }
    }

    static int dfs(int nowY, int nowX, boolean[][] visit) {
        visit[nowY][nowX] = true;

        int score = 1;

        for(int drct = 0; drct < 4; drct++) {
            int ny = nowY + DY[drct];
            int nx = nowX + DX[drct];

            if(!canMove(ny, nx) || board[ny][nx] != board[nowY][nowX] || visit[ny][nx]) continue;

            score += dfs(ny, nx, visit);
        }

        return score;
    }
}