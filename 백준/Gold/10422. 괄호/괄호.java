import java.util.Scanner;

public class Main {
    static final int MOD = 1000000007;
    static Scanner sc = new Scanner(System.in);
    static int l;
    static long[] dp = new long[5001];
    static StringBuilder ansMaker = new StringBuilder();


    public static void main(String[] args) {
        int t = sc.nextInt();
        countBracket();

        while(t-- > 0) {
            input();
            ansMaker.append(dp[l]).append("\n");
        }

        System.out.print(ansMaker);
    }

    static void input() {
        l = sc.nextInt();
    }

    static void countBracket() {
        dp[0] = 1;
        dp[2] = 1;

        for(int i = 4; i <= 5000; i += 2) {
            for(int j = 0; j < i; j += 2) {
                dp[i] += (dp[j] * dp[(i - 2 - j)]);
                dp[i] %= MOD;
            }
        }
    }
}