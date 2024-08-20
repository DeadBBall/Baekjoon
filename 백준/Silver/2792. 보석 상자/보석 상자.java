import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int m, n, left, right, ans;
    static int[] gems;

    public static void main(String[] args) {
        input();
        distribute();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        gems = new int[m];

        for(int idx = 0; idx < m; idx++) {
            gems[idx] = sc.nextInt();
            right = Math.max(right, gems[idx]);
        }

        left = 1;
    }

    static void distribute() {
        while(left <= right) {
            int mid = (left + right) >> 1;

            if(count(mid) <= n) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }

    static int count(int limit) {
        int cnt = 0;

        for(int idx = 0; idx < m; idx++) {
            cnt += gems[idx] / limit;

            if(gems[idx] % limit != 0) {
                cnt ++;
            }
        }

        return cnt;
    }
}