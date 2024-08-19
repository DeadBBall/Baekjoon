import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int m, n;
    static int[] snacks;
    static long left, right;

    public static void main(String[] args) {
        input();
        System.out.println(distributeSnacks());
    }

    static void input() {
        m = sc.nextInt();
        n = sc.nextInt();
        snacks = new int[n];

        for(int idx = 0; idx < n; idx++) {
            snacks[idx] = sc.nextInt();
            right = Math.max(right, snacks[idx]);
        }

        left = 1;
    }

    static long distributeSnacks() {
        long ans = 0;

        while(left <= right) {
            long mid = (left + right) >> 1;

            if(countSnacks(mid) >= m) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    static int countSnacks(long limit) {
        int cnt = 0;

        for(int idx = 0; idx < n; idx++) {
            cnt += (int) (snacks[idx] / limit);
        }

        return cnt;
    }
}