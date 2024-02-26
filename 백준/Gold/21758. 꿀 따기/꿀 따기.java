import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static int[] honey;
    static int[] accumulatedSum, reverseAccumulatedSum;

    public static void main(String[] args) {
        input();
        pickHoney();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        honey = new int[n];

        for(int honeyIdx = 0; honeyIdx < n; honeyIdx++) {
            honey[honeyIdx] = sc.nextInt();
        }

        accumulatedSum = new int[n + 1];
        reverseAccumulatedSum = new int[n + 1];

        for(int honeyIdx = 0; honeyIdx < n; honeyIdx++) {
            accumulatedSum[honeyIdx + 1] = accumulatedSum[honeyIdx] + honey[honeyIdx];
            reverseAccumulatedSum[n - honeyIdx - 1] = reverseAccumulatedSum[n - honeyIdx] + honey[n - honeyIdx - 1];
        }
    }

    static void pickHoney() {
        for(int honeyIdx = 1; honeyIdx < n - 1; honeyIdx++) {
            ans = Math.max(ans, reverseAccumulatedSum[1] + reverseAccumulatedSum[honeyIdx + 1] - honey[honeyIdx]);
            ans = Math.max(ans, accumulatedSum[n - 1] + accumulatedSum[n - honeyIdx - 1] - honey[n - honeyIdx - 1]);
        }

        for(int honeyIdx = 1; honeyIdx < n - 1; honeyIdx++) {
            ans = Math.max(ans, accumulatedSum[n] - honey[0] - honey[n - 1] + honey[honeyIdx]);
        }
    }
}