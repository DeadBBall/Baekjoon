import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static int[] numbers;

    public static void main(String[] args) {
        input();
        convert(0, 0, 0);
        System.out.println(ans == n + 1 ? -1 : ans);
    }

    static void input() {
        n = sc.nextInt();
        numbers = new int[n];

        for(int idx = 0; idx < n; idx++) {
            numbers[idx] = sc.nextInt();
        }

        ans = n + 1;
    }

    static void convert(int idx, int diff, int cnt) {
        if(idx == n) {
            ans = Math.min(ans, cnt);
            return;
        }

        if(idx <= 1) {
            convert(idx + 1, idx == 0 ? 0 : numbers[idx - 1] - numbers[idx], cnt);

            numbers[idx]++;

            convert(idx + 1, idx == 0 ? 0 : numbers[idx - 1] - numbers[idx], cnt + 1);

            numbers[idx] -= 2;

            convert(idx + 1, idx == 0 ? 0 : numbers[idx - 1] - numbers[idx], cnt + 1);

            numbers[idx]++;
        } else {
            if(numbers[idx - 1] - numbers[idx] == diff) {
                convert(idx + 1, diff, cnt);
            }

            if(numbers[idx - 1] - numbers[idx] - 1 == diff) {
                numbers[idx]++;
                convert(idx + 1, diff, cnt + 1);
                numbers[idx]--;
            }

            if(numbers[idx - 1] - numbers[idx] + 1 == diff) {
                numbers[idx]--;
                convert(idx + 1, diff, cnt + 1);
                numbers[idx]++;
            }
        }
    }
}