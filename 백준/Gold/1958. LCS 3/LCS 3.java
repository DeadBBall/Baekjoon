import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String str, str2, str3;
    static int[][][] dp;

    public static void main(String[] args) {
        input();
        findLCSLenBetween3();
        System.out.println(dp[str.length()][str2.length()][str3.length()]);
    }

    static void input() {
        str = sc.next();
        str2 = sc.next();
        str3 = sc.next();
        dp = new int[str.length() + 1][str2.length() + 1][str3.length() + 1];
    }

    static void findLCSLenBetween3() {
        for(int i = 1; i <= str.length(); i++) {
            char c = str.charAt(i - 1);

            for(int j = 1; j <= str2.length(); j++) {
                char c2 = str2.charAt(j - 1);

                for(int k = 1; k <= str3.length(); k++) {
                    char c3 = str3.charAt(k - 1);

                    if(c == c2 && c2 == c3) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
                    }
                }
            }
        }
    }
}