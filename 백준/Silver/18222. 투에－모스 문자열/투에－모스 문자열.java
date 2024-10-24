import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static long k;
    static long[] dp;

    public static void main(String[] args) {
        input();
        System.out.println(findK(k));
    }

    static void input() {
        k = sc.nextLong();
        dp = new long[64];

        dp[0] = 1;

        for (int i = 1; i < 64; i++){
            dp[i] = dp[i-1] * 2;
        }
    }

    static int findK(long rest) {
        if(rest == 1) return 0;

        for (int i = 0; i < 64; i++){
            if (dp[i] >= rest) return 1 - findK(rest - dp[i-1]);
        }

        return 0;
    }

}