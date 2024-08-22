import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int s, c, left, right;
    static long ans;
    static int[] lens;

    public static void main(String[] args) {
        input();
        distribute();
        System.out.println(ans);
    }

    static void input() {
        s = sc.nextInt();
        c = sc.nextInt();
        lens = new int[s];

        for(int idx = 0; idx < s; idx++) {
            lens[idx] = sc.nextInt();
            right = Math.max(right, lens[idx]);
            ans += lens[idx];
        }

        left = 1;
    }

    static void distribute() {
        long max = 0;

        while(left <= right) {
            int mid = (right - left) / 2 + left;

            if(count(mid) < c) {
                right = mid - 1;
            } else {
                left = mid + 1;
                max = mid;
            }
        }

        ans -= (max * c);
    }

    static int count(int limit) {
        int cnt = 0;

        for(int idx = 0; idx < s; idx++) {
            cnt += lens[idx] / limit;
        }

        return cnt;
    }
}