import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans, min, max;
    static int[] costs;

    public static void main(String[] args) {
        input();
        makeMoney();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        costs = new int[n];

        for(int day = 0; day < n; day++) {
            costs[day] = sc.nextInt();
        }
    }

    static void makeMoney() {
        min = max = costs[0];

        for(int day = 1; day < n; day++) {
            if(costs[day] < min) {
                min = costs[day];
                max = costs[day];
            }
            else if(costs[day] > max) {
                max = costs[day];
                ans = Math.max(ans, max - min);
            }
        }
    }

}