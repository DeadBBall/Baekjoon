import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static final int INF = 123456789;
    static int n;
    static int[][] matrixs;
    static int[][] dp;

    public static void main(String[] args) {
        input();
        multiflyMatrix();
        System.out.println(dp[1][n]);
    }

    static void input() {
        n = sc.nextInt();
        matrixs = new int[n + 1][2];
        dp = new int[n + 1][n + 1];

        for(int matrixIdx = 1; matrixIdx <= n; matrixIdx++) {
            for(int j = 0; j < 2; j++) {
                matrixs[matrixIdx][j] = sc.nextInt();
            }
        }

    }

    static void multiflyMatrix() {
        for(int i = 1; i < n; i++) {

            for(int j = 1; i + j <= n; j++) {
                dp[j][i + j] = INF;

                for(int k = j; k < i + j; k++) {
                    dp[j][i + j] = Math.min(dp[j][i + j], dp[j][k] + dp[k + 1][i + j] + matrixs[j][0] * matrixs[k][1] * matrixs[i + j][1]);
                }
            }
        }
    }

}