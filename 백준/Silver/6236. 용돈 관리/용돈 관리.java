import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m, right, left;
    static int[] costs;

    public static void main(String[] args) {
        input();
        System.out.println(makePlan());
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        costs = new int[n];

        for(int idx = 0; idx < n; idx++) {
            costs[idx] = sc.nextInt();
            left = Math.max(left, costs[idx]);
            right += costs[idx];
        }
    }

    static int makePlan() {
        while(left < right) {
            int mid = (left + right) >> 1;

            if(count(mid) <= m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    static int count(int limit) {
        int cnt = 1;
        int balance = limit;

        for(int cost : costs) {
            balance -= cost;

            if(balance < 0) {
                cnt++;
                balance = limit - cost;
            }
        }

        return cnt;
    }

}