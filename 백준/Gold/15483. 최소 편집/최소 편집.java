import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String origin, target;
    static int[][] dp;

    public static void main(String[] args) {
        input();
        edit();
        System.out.println(dp[origin.length()][target.length()]);
    }

    static void input() {
        origin = sc.next();
        target = sc.next();
        dp = new int[origin.length() + 1][target.length() + 1];
    }

    static void edit() {
        for(int oIdx = 1; oIdx <= origin.length(); oIdx++) {
            dp[oIdx][0] = oIdx;

            for(int tIdx = 1; tIdx <= target.length(); tIdx++) {
                dp[0][tIdx] = tIdx;

                if(origin.charAt(oIdx - 1) == target.charAt(tIdx - 1)) {
                    dp[oIdx][tIdx] = dp[oIdx - 1][tIdx - 1];
                } else {
                    dp[oIdx][tIdx] = Math.min(Math.min(dp[oIdx - 1][tIdx], dp[oIdx][tIdx - 1]), dp[oIdx - 1][tIdx - 1]) + 1;
                }
            }
        }
    }

}