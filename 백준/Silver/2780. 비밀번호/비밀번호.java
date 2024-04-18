import java.util.*;

public class Main {
    static final int MOD = 1_234_567;
    static final int[] DY = {1, -1, 0, 0};
    static final int[] DX = {0, 0, 1, -1};
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker = new StringBuilder();
    static int n;
    static int[][] board = new int[3][3];
    static int[][] dp = new int[1001][10];

    public static void main(String[] args) {
        int t = sc.nextInt();
        countPassword();

        while(t-- > 0) {
            input();

            int ans = 0;

            for(int cnt : dp[n]) {
                ans = (ans + cnt) % MOD;
            }

            ansMaker.append(ans).append("\n");
        }

        System.out.print(ansMaker);
    }

    static void countPassword() {
        Arrays.fill(dp[1], 1);

        int num = 1;

        for(int y = 0; y < 3; y++) {
            for(int x = 0; x < 3; x++) {
                board[y][x] = num++;
            }
        }

        for(int idx = 2; idx <= 1000; idx++) {
            dp[idx][0] = dp[idx - 1][7];
            dp[idx][7] = dp[idx - 1][0];

            for(int y = 0; y < 3; y++) {
                for(int x = 0; x < 3; x++) {
                    for(int drct = 0; drct < 4; drct++) {
                        int ny = y + DY[drct];
                        int nx = x + DX[drct];

                        if(!canMove(ny, nx)) continue;

                        dp[idx][board[y][x]] = (dp[idx][board[y][x]] + dp[idx - 1][board[ny][nx]]) % MOD;
                    }
                }
            }
        }
    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < 3 && x >= 0 && x < 3;
    }

    static void input() {
        n = sc.nextInt();
    }

}