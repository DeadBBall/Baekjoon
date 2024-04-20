import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m, k, ans;
    static int[][] dp, board;

    public static void main(String[] args) {
        input();
        travel();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        dp = new int[n + 1][m + 1];
        board = new int[n + 1][n + 1];

        while(k-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if(a > b) continue;

            if(board[a][b] == 0 || board[a][b] < c) {
                board[a][b] = c;
            }

            if(a == 1 && (dp[b][2] == 0 || dp[b][2] < c)) {
                dp[b][2] = c;
            }
        }
    }

    static void travel() {
        for(int cnt = 3; cnt <= m; cnt++) {
            for(int now = 1; now <= n; now++) {
                for(int prev = 1; prev < now; prev++) {
                    if(board[prev][now] * dp[prev][cnt - 1] == 0) continue;

                    dp[now][cnt] = Math.max(dp[now][cnt], dp[prev][cnt - 1] + board[prev][now]);
                }
            }
        }

        for(int cnt = 1; cnt <= m; cnt++) {
            ans = Math.max(ans, dp[n][cnt]);
        }
    }

}