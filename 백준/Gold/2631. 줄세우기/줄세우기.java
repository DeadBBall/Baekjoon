import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int[] children;
    static int[] dp;
    static int ans;

    public static void main(String[] args) {
        input();
        lineUp();
        System.out.println(n - ans);
    }

    static void input() {
        n = sc.nextInt();
        children = new int[n];
        dp = new int[n];
        dp[0] = 1;
        for(int cIdx = 0; cIdx < n; cIdx++) {
            children[cIdx] = sc.nextInt();
        }

    }

    static void lineUp() {
        for(int max = 1; max < n; max++) {

            dp[max] = 1;
            for(int now = 0; now < max; now++) {

                if(children[now] < children[max]) {
                    dp[max] = Math.max(dp[now] + 1, dp[max]);
                }

            }

            ans = Math.max(ans, dp[max]);

        }

    }

}