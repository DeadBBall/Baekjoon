import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String number;
    static int[] dp;

    public static void main(String[] args) {
        input();
        System.out.println(countCards(0));
    }

    static void input() {
        number = sc.next();
        dp = new int[number.length()];
    }

    static int countCards(int cardIdx) {
        if(cardIdx == number.length()) return 1;

        if(dp[cardIdx] != 0 || number.charAt(cardIdx) == '0') return dp[cardIdx];

        dp[cardIdx] += countCards(cardIdx + 1);

        if(cardIdx + 1 < number.length() && number.substring(cardIdx, cardIdx + 2).compareTo("34") <= 0) {
            dp[cardIdx] += countCards(cardIdx + 2);
        }

        return dp[cardIdx];
    }
}