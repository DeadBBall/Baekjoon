import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker = new StringBuilder();
    static int n, k;
    static int[][][] dp = new int[101][101][2];

    public static void main(String[] args) {
        countBit();

        int t = sc.nextInt();

        while(t-- > 0) {
            input();
            ansMaker.append(dp[n][k][0] + dp[n][k][1]).append("\n");
        }

        System.out.print(ansMaker);
    }

    static void countBit() {
        dp[1][0][0] = dp[1][0][1] = 1;
        dp[1][1][0] = dp[1][1][1] = 0;

        for(int bit = 2; bit <= 100; bit++) {
            dp[bit][0][0] = dp[bit - 1][0][0] + dp[bit - 1][0][1];
            dp[bit][0][1] = dp[bit - 1][0][0];

            for(int kCount = 1; kCount < bit; kCount++) {
                dp[bit][kCount][0] = dp[bit - 1][kCount][0] + dp[bit - 1][kCount][1];
                dp[bit][kCount][1] = dp[bit - 1][kCount][0] + dp[bit - 1][kCount - 1][1];
            }
        }
    }

    static void input() {
        n = sc.nextInt();
        k = sc.nextInt();
    }

}