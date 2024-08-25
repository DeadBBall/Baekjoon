import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int m, l, left, right, ans;
    static int[] cakes;
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        input();

        while(n-- > 0) {
            distribute();
        }

        System.out.print(ansMaker);
    }

    static void input() {
        m = sc.nextInt();
        l = sc.nextInt();
        cakes = new int[m + 1];

        for(int idx = 0; idx < m; idx++) {
            cakes[idx] = sc.nextInt();
        }

        cakes[m] = l;
    }

    static void distribute() {
        int q = sc.nextInt();

        left = 1;
        right = l;

        while(left <= right) {
            int mid = (right - left) / 2 + left;

            if(count(mid) <= q) {
                right = mid - 1;
            } else {
                ans = mid;
                left = mid + 1;
            }
        }

        ansMaker.append(ans).append("\n");
    }

    static int count(int limit) {
        int cnt = 0;
        int nowCake = 0;

        int prev = 0;

        for(int idx = 0; idx <= m; idx++) {
            nowCake += cakes[idx] - prev;

            prev = cakes[idx];

            if(nowCake >= limit) {
                cnt++;
                nowCake = 0;
            }
        }

        return cnt;
    }
}