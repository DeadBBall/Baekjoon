import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static int[] numbers;
    static int[][] dp;

    public static void main(String[] args) {
        input();
        findSequence();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        numbers = new int[n];
        dp = new int[n][2];

        for(int numIdx = 0; numIdx < n; numIdx++) {
            numbers[numIdx] = sc.nextInt();
        }

        ans = dp[0][0] = dp[0][1] = numbers[0];
    }

    static void findSequence() {
        for(int numIdx = 1; numIdx < n; numIdx++) {
            dp[numIdx][0] = Math.max(dp[numIdx - 1][0] + numbers[numIdx], numbers[numIdx]);

            dp[numIdx][1] = Math.max(dp[numIdx - 1][1] + numbers[numIdx], dp[numIdx - 1][0]);

            ans = Math.max(ans, Math.max(dp[numIdx][0], dp[numIdx][1]));
        }
    }

}