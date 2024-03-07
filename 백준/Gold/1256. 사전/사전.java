import java.util.*;

public class Main {
    static final int INF = 1000000001;
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker;
    static int n, m, k;
    static int[][] dp;

    public static void main(String[] args) {
        input();
        findStr(n, m, k);
        System.out.println(dp[n][m] >= k ? ansMaker : -1);
    }

    static void input() {
        ansMaker = new StringBuilder();
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        dp = new int[n + 1][m + 1];

        for(int a = 1; a <= n; a++) {
            dp[a][0] = 1;
        }

        for(int z = 1; z <= m; z++) {
            dp[0][z] = 1;
        }

        for(int a = 1; a <= n; a++) {
            for(int z = 1; z <= m; z++) {
                dp[a][z] = Math.min(dp[a - 1][z] + dp[a][z - 1], INF);
            }
        }
    }

    static void findStr(int a, int z, int remainder) {
        if(a == 0) {
            while(z-- > 0){
                ansMaker.append("z");
            }
            return;
        }

        if(z == 0) {
            while(a-- > 0) {
                ansMaker.append("a");
            }
            return;
        }

        int count = dp[a - 1][z];

        if(count < remainder) {
            ansMaker.append("z");
            findStr(a, z - 1, remainder - count);
        }
        else {
            ansMaker.append("a");
            findStr(a - 1, z, remainder);
        }
    }
}