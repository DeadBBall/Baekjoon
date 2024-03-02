import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m, ans;
    static int[] numbers;

    public static void main(String[] args) {
        input();
        selectNumbers();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        numbers = new int[n];
        ans = Integer.MAX_VALUE;

        for(int numIdx = 0; numIdx < n; numIdx++) {
            numbers[numIdx] = sc.nextInt();
        }

        Arrays.sort(numbers);
    }

    static void selectNumbers() {
        int leftIdx = 0;
        int rightIdx = 0;

        while(leftIdx < n && rightIdx < n) {
            int diff = numbers[rightIdx] - numbers[leftIdx];

            if(diff < m) {
                rightIdx++;
            }
            else if(diff > m) {
                leftIdx++;
                ans = Math.min(ans, diff);
            }
            else {
                ans = diff;
                return;
            }
        }
    }
}