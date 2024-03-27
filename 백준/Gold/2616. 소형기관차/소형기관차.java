import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int carSize, pullCount;
    static int[] cars;
    static int[] accSums;
    static int[][] dp;

    public static void main(String[] args) {
        input();
        pullCars();
        System.out.println(dp[3][carSize]);
    }

    static void input() {
        carSize = sc.nextInt();
        cars = new int[carSize];
        accSums = new int[carSize + 1];

        for(int carIdx = 0; carIdx < carSize; carIdx++) {
            cars[carIdx] = sc.nextInt();
            accSums[carIdx + 1] = accSums[carIdx] + cars[carIdx];
        }

        pullCount = sc.nextInt();
        dp = new int[4][carSize + 1];
    }

    static void pullCars() {
        for(int locoIdx = 1; locoIdx <= 3; locoIdx++) {
            for(int carIdx = locoIdx * pullCount; carIdx <= carSize; carIdx++) {
                dp[locoIdx][carIdx] = Math.max(dp[locoIdx][carIdx - 1],
                        dp[locoIdx - 1][carIdx - pullCount] + accSums[carIdx] - accSums[carIdx - pullCount]);
            }
        }
    }
}
