import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static int[] numbers;
    static int[] dpLeft, dpRight;

    public static void main(String[] args) {
        input();
        findSequence();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        numbers = new int[n];
        dpLeft = new int[n];
        dpRight = new int[n];

        for(int numIdx = 0; numIdx < n; numIdx++) {
            numbers[numIdx] = sc.nextInt();
        }

        dpLeft[0] = ans = numbers[0];
        dpRight[n - 1] = numbers[n - 1];
    }

    static void findSequence() {
        for(int numIdx = 1; numIdx < n; numIdx++) {
            dpLeft[numIdx] = Math.max(dpLeft[numIdx - 1] + numbers[numIdx] , numbers[numIdx]);
            dpRight[n - 1 - numIdx] = Math.max(dpRight[n - numIdx] + numbers[n - 1 - numIdx], numbers[n - 1 - numIdx]);
            
            ans = Math.max(ans, dpLeft[numIdx]);
        }

        for(int numIdx = 1; numIdx < n - 1; numIdx++) {
            int sum = dpLeft[numIdx - 1] + dpRight[numIdx + 1];

            ans = Math.max(sum, ans);
        }
    }

}