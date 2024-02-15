import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static int[] cards, dp;

    public static void main(String[] args) {
        input();
        lis();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        cards = new int[n];
        dp = new int[n];

        for(int cardIdx = 0; cardIdx < n; cardIdx++) {
            cards[cardIdx] = sc.nextInt();
        }
    }

    static void lis() {
        for(int end = 0; end < n; end++) {
            dp[end] = 1;

            for(int start = 0; start < end; start++) {

                if(cards[end] > cards[start]) {
                    dp[end] = Math.max(dp[end], dp[start] + 1);
                }
            }

            ans = Math.max(dp[end], ans);
        }
    }

}