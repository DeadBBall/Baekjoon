import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, k, left, right, ans;
    static int[] drinks;

    public static void main(String[] args) {
        input();
        distribute();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        k = sc.nextInt();
        drinks = new int[n];

        for(int idx = 0; idx < n; idx++) {
            drinks[idx] = sc.nextInt();
            right = Math.max(right, drinks[idx]);
        }

        left = 1;
    }

    static void distribute() {
        while(left <= right) {
            int mid = (right - left) / 2 + left;

            if(count(mid) < k) {
                right = mid - 1;
            } else {
                left = mid + 1;
                ans = mid;
            }
        }
    }

    static int count(int limit) {
        int cnt = 0;

        for(int idx = 0; idx < n; idx++) {
            cnt += drinks[idx] / limit;
        }

        return cnt;
    }
}