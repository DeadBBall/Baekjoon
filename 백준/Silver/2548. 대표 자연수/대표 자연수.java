import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, minDiff, ans;
    static int[] numbers;

    public static void main(String[] args) {
        input();
        searchNaturalNumber();
        System.out.println(ans);
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

    static void searchNaturalNumber() {
        for(int number = 1; number <= numbers[n - 1]; number++) {
            int diff = calulateDiff(number);
            if(diff < minDiff) {
                ans = number;
                minDiff = diff;
            }
            else return;
        }
    }

    static int calulateDiff(int number) {
        int result = 0;
        for(int numIdx = 0; numIdx < n; numIdx++) {
            result += Math.abs(number - numbers[numIdx]);
        }
        return result;
    }
}