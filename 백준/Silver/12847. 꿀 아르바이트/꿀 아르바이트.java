import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static long ans;
    static int[] costs;

    public static void main(String[] args) {
        input();
        work();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        costs = new int[n];

        for(int idx = 0; idx < n; idx++) {
            costs[idx] = sc.nextInt();
        }
    }

    static void work() {
        long totalCost = 0;
        int len = 0;

        for(int idx = 0; idx < n; idx++) {
            totalCost += costs[idx];

            if(len < m) {
                len++;
            } else {
                totalCost -= costs[idx - len];
            }

            ans = Math.max(totalCost, ans);
        }
    }
}