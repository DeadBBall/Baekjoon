import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, k;
    static List<Integer> dp;

    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {
        int t = sc.nextInt();

        for(int idx = 1; idx <= t; idx++) {
            ansMaker.append("Case #").append(idx).append("\n");
            input();
            tradeStocks();
        }

        System.out.print(ansMaker);
    }


    static void input() {
        n = sc.nextInt();
        k = sc.nextInt();
        dp = new ArrayList<>();
        dp.add(10001);
    }

    static void tradeStocks() {
        while(n-- > 0) {
            int now = sc.nextInt();

            if(now > dp.get(dp.size() - 1)) {
                dp.add(now);
            } else {
                int left = 0;
                int right = dp.size();

                while(left < right) {
                    int mid = (left + right) >> 1;

                    if(dp.get(mid) < now) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                dp.set(right, now);
            }
        }

        ansMaker.append(dp.size() >= k ? 1 : 0).append("\n");
    }
}