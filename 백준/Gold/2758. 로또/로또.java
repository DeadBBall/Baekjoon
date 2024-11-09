import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static long[][] dp;
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {
        int t = sc.nextInt();

        while(t-- > 0) {
            input();
            buyLotto();
        }

        System.out.print(ansMaker);
    }


    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();

        dp = new long[n + 1][m + 1];
        Arrays.fill(dp[1], 1);
    }

    static void buyLotto() {
        long ans = 0;

        for(int cnt = 2; cnt <= n; cnt++) {
            for(int now = 1; now <= m; now++) {
                for(int next = now * 2; next <= m; next++) {
                    dp[cnt][next] += dp[cnt - 1][now];
                }
            }
        }

        for(int num = 1; num <= m; num++) {
            ans += dp[n][num];
        }

        ansMaker.append(ans).append("\n");
    }
}