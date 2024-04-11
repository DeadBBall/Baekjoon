import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int[] counts = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
    static String a, b;
    static int[][] dp;

    public static void main(String[] args) {
        input();
        testCompatibility();
        System.out.print(dp[a.length() + b.length() - 2][0]);
        System.out.print(dp[a.length() + b.length() - 2][1]);
    }

    static void input() {
        a = sc.next();
        b = sc.next();

        dp = new int[a.length() + b.length() - 1][a.length() + b.length()];

        for(int idx = 0; idx < a.length() + b.length(); idx++) {
            dp[0][idx] = idx % 2 == 0 ? counts[a.charAt(idx / 2) - 'A'] : counts[b.charAt(idx / 2) - 'A'];
        }
    }

    static void testCompatibility() {
        for(int height = 1; height < a.length() + b.length() - 1; height++) {
            for(int idx = 0; idx < a.length() + b.length() - height; idx++) {
                dp[height][idx] = (dp[height - 1][idx] + dp[height - 1][idx + 1]) % 10;
            }
        }
    }

}