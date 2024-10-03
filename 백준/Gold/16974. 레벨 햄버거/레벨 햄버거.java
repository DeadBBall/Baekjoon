import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static long X;
    static long[] dp, total;

    public static void main(String[] args) {
        input();
        System.out.println(count(N, X));
    }

    static void input() {
        N = sc.nextInt();
        X = sc.nextLong();
        dp = new long[N + 1];
        total = new long[N + 1];

        total[0] = 1;
        dp[0] = 1;

        for(int idx = 1; idx <= N; idx++) {
            dp[idx] = dp[idx - 1] * 2 + 1;
            total[idx] = total[idx - 1] * 2 + 3;
        }
    }

    static long count(int n, long x) {
        if(n == 0) {
            if(x == 0) return 0;
            else if(x == 1) return 1;
        }

        if(x == 1) return 0;
        else if(x <= 1 + total[n - 1]) return count(n - 1, x - 1);
        else if(x == 1 + total[n - 1] + 1) return dp[n - 1] + 1;
        else if(x <= 1 + total[n - 1] + 1 + total[n - 1])
            return dp[n - 1] + 1 + count(n - 1, x - (1 + total[n - 1] + 1));
        else return dp[n - 1] + 1 + dp[n - 1];
    }

}