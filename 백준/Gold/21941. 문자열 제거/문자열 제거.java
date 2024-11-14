import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String s;
    static int m;
    static DeletionRule[] deletionRules;
    static int[] dp;

    public static void main(String[] args) {
        input();
        removeS();
        System.out.println(dp[s.length()]);
    }


    static void input() {
        s = sc.next();
        m = sc.nextInt();
        deletionRules = new DeletionRule[m];

        for(int idx = 0; idx < m; idx++) {
            deletionRules[idx] = new DeletionRule(sc.next(), sc.nextInt());
        }

        dp = new int[s.length() + 1];
    }

    static void removeS() {
        for(int sIdx = 0; sIdx < s.length(); sIdx++) {
            dp[sIdx + 1] = dp[sIdx] + 1;

            for(int rIdx = 0; rIdx < m; rIdx++) {
                DeletionRule nowRule = deletionRules[rIdx];

                if(sIdx + 1 < nowRule.pattern.length()) continue;

                if(nowRule.pattern.equals(s.substring(sIdx + 1 - nowRule.pattern.length(), sIdx + 1))) {
                    dp[sIdx + 1] = Math.max(dp[sIdx + 1], dp[sIdx + 1 -
                            nowRule.pattern.length()] + nowRule.score);
                }
            }
        }
    }

}

class DeletionRule {
    String pattern;
    int score;

    public DeletionRule(String pattern, int score) {
        this.pattern = pattern;
        this.score = score;
    }
}