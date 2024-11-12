import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String str, str2;
    static int[][] dp;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        makePassword();
        System.out.print(ansMaker);
    }


    static void input() {
        str = sc.next();
        str2 = sc.next();
        dp = new int[str.length() + 1][str2.length() + 1];
        ansMaker = new StringBuilder();
    }

    static void makePassword() {
        for(int i = 0; i < str.length(); i++) {
            for(int j = 0; j < str2.length(); j++) {
                if(str.charAt(i) == str2.charAt(j)) {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + 1);
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        int i = str.length();
        int j = str2.length();

        while(dp[i][j] > 0) {
            if(dp[i][j] == dp[i - 1][j]) i--;
            else if(dp[i][j] == dp[i][j - 1])j--;
            else {
                ansMaker.insert(0, str.charAt(i - 1));
                i--;
                j--;
            }
        }

    }
}