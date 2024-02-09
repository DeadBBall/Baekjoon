import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int n;
    static int[] dp;

    public static void main(String[] args) {
        input();
        shakeHands();
        System.out.print(dp[n]);
    }

    static void input() {
        n = sc.nextInt();
        dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
    }

    static void shakeHands() {
        for(int people = 2; people <= n; people++) {
            dp[people] = (dp[people - 1] + dp[people - 2]) % 10;
        }
    }

}