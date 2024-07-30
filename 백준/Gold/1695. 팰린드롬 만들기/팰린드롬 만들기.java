import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int[] numbers;
    static int[][] dp;

    public static void main(String[] args) {
        input();
        System.out.println(makePal(0, n - 1));
    }

    static void input() {
        n = sc.nextInt();
        numbers = new int[n];

        for(int idx = 0; idx < n; idx++) {
            numbers[idx] = sc.nextInt();
        }

        dp = new int[n][n];

        for(int left = 0; left < n; left++) {
            Arrays.fill(dp[left], -1);
        }
    }

    static int makePal(int left, int right) {
        if(left > right) return 0;

        if(dp[left][right] != -1) return dp[left][right];

        if(numbers[left] == numbers[right]) {
            dp[left][right] = makePal(left + 1, right - 1);
        } else {
            dp[left][right] = Math.min(makePal(left + 1, right) + 1, makePal(left, right - 1) + 1);
        }

        return dp[left][right];
    }

}