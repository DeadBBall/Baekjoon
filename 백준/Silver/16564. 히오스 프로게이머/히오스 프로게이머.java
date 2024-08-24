import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, k, left, right, ans;
    static int[] costs;

    public static void main(String[] args) {
        input();
        distribute();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        k = sc.nextInt();
        costs = new int[n];

        left = Integer.MAX_VALUE;

        for(int idx = 0; idx < n; idx++) {
            costs[idx] = sc.nextInt();
            right = Math.max(right, costs[idx]);
            left = Math.min(left, costs[idx]);
        }

        right += k;
    }

    static void distribute() {
        while(left <= right) {
            int mid = (right - left) / 2 + left;
            
            if(count(mid) < n) {
                right = mid - 1;
            } else {
                ans = mid;
                left = mid + 1;
            }
        }
    }

    static int count(int limit) {
        int cnt = 0;
        int plusLevel = k;

        for(int idx = 0; idx < n; idx++) {
            if(costs[idx] + plusLevel >= limit) {
                cnt++;
                plusLevel -= (costs[idx] >= limit ? 0 : limit - costs[idx]);
            }
        }

        return cnt;
    }
}