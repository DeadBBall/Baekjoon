import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static long ans;
    static long[] costs;

    public static void main(String[] args) {
        input();
        travel();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        costs = new long[n];

        for(int idx = 0; idx < n; idx++) {
            long time = sc.nextLong();
            costs[idx] = time;
        }
        ans = Long.MAX_VALUE;
    }

    static void travel() {
        long left = 0;
        long right = Long.MAX_VALUE;

        while(left <= right) {
            long mid = (left + right) >> 1;

            long cnt = 0;

            for(long cost : costs) {
                cnt += mid / cost;

                if(cnt > m) break;
            }

            if(cnt < m) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
                ans = Math.min(ans, mid);
            }
        }
    }

}