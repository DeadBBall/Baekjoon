import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int m, l, left, right, ans;
    static List<Integer> cakes;
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
        cakes = new ArrayList<>();

        cakes.add(0);

        for(int idx = 1; idx <= m; idx++) {
            cakes.add(sc.nextInt());
        }

        if(cakes.get(m) != l) {
            cakes.add(l);
        }
    }

    static void distribute() {
        int q = sc.nextInt();

        left = 1;
        right = cakes.get(cakes.size() - 1);

        while(left <= right) {
            int mid = (right - left) / 2 + left;

            if(count(mid) < q + 1) {
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

        for(int idx = 1; idx < cakes.size(); idx++) {
            nowCake += cakes.get(idx) - cakes.get(idx - 1);

            if(nowCake >= limit) {
                cnt++;
                nowCake = 0;
            }
        }

        return cnt;
    }
}