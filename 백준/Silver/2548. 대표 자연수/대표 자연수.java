import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, minDiff, ans;
    static int[] numbers;

    public static void main(String[] args) {
        input();
        System.out.println(n % 2 == 0 ? numbers[n / 2 - 1] : numbers[n / 2]);
    }
    static void input() {
        n = sc.nextInt();
        numbers = new int[n];
        minDiff = Integer.MAX_VALUE;

        for(int numIdx = 0; numIdx < n; numIdx++) {
            numbers[numIdx] = sc.nextInt();
        }
        Arrays.sort(numbers);
    }
}