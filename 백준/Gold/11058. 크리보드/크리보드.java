import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static long[] dp;

    public static void main(String[] args) {
        input();
        printA();
        System.out.println(dp[n]);
    }

    static void input() {
        n = sc.nextInt();
        dp = new long[n + 1];
    }

    static void printA() {
        for(int pressureCount = 1; pressureCount <= 6 && pressureCount <= n; pressureCount++) {
            dp[pressureCount] = pressureCount;
        }

        for(int pressureCount = 7; pressureCount <= n; pressureCount++) {
            for(int pasteCount = 1; pasteCount <= 4; pasteCount++) {
                dp[pressureCount] = Math.max(dp[pressureCount], dp[pressureCount - pasteCount - 2] * (pasteCount + 1));
            }
        }
    }
}