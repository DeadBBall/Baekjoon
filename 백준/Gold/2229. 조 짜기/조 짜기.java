import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int[] scores;
    static int[] dp;

    public static void main(String[] args) {
        input();
        formGroups();
        System.out.println(dp[n]);
    }

    static void input() {
        n = sc.nextInt();
        scores = new int[n + 1];

        for(int scoreIdx = 1; scoreIdx <= n; scoreIdx++) {
            scores[scoreIdx] = sc.nextInt();
        }

        dp = new int[n + 1];
    }

    static void formGroups() {
        for(int right = 1; right <= n; right++) {
            int maxScore = Integer.MIN_VALUE;
            int minScore = Integer.MAX_VALUE;

            for(int left = right; left > 0; left--) {
                maxScore = Math.max(maxScore, scores[left]);
                minScore = Math.min(minScore, scores[left]);

                dp[right] = Math.max(dp[right], dp[left - 1] + maxScore - minScore);
            }
        }
    }

}