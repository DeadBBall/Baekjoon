import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, max;
    static int[] dp;

    public static void main(String[] args) {
        input();
        lineUp();
        System.out.println(n - max);
    }

    static void input() {
        n = sc.nextInt();
        dp = new int[n + 1];

        for(int idx = 0; idx < n; idx++) {
            int num = sc.nextInt();
            dp[num] = dp[num - 1] + 1;
        }
    }

    static void lineUp() {
        for(int num : dp) {
            max = Math.max(num, max);
        }
    }
}