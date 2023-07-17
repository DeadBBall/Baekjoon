import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, s, m, ans;
    static int[] board;
    static boolean[][] dp;

    static void input() {
        n = sc.nextInt();
        s = sc.nextInt();
        m = sc.nextInt();
        board = new int[n + 1];
        dp = new boolean[n + 1][1001];
        ans = -1;
        dp[0][s] = true;
        for(int idx = 1; idx <= n; idx++) {
            board[idx] = sc.nextInt();
        }
    }

    static void play(int idx, int now) {
        if(idx == n + 1) {
            ans = Math.max(ans, now);
            return;
        }

        if(now + board[idx] <= m) {
            if(!dp[idx][now + board[idx]]) {
                dp[idx][now + board[idx]] = true;
                play(idx + 1, now + board[idx]);
            }
        }
        if(now - board[idx] >= 0) {
            if(!dp[idx][now - board[idx]]) {
                dp[idx][now - board[idx]] = false;
                play(idx + 1, now - board[idx]);
            }
        }
    }

    public static void main(String[] args) {
        input();
        play(1, s);
        System.out.println(ans);
    }

}