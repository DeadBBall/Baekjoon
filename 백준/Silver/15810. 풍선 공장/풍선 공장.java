import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static long left, right, ans;
    static int[] costs;

    public static void main(String[] args) {
        input();
        distribute();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        costs = new int[n];

        for(int idx = 0; idx < n; idx++) {
            costs[idx] = sc.nextInt();
            right = Math.max(right, costs[idx]);
            ans += costs[idx];
        }

        left = 1;
        right *= m;
    }

    static void distribute() {
        while(left <= right) {
            long mid = (right - left) / 2 + left;

            if(count(mid) >= m) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
    }

    static long count(long limit) {
        long cnt = 0;

        for(int idx = 0; idx < n; idx++) {
            cnt += limit / costs[idx];
        }

        return cnt;
    }
}