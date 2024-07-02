import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static long[] costs;
    static long m;

    public static void main(String[] args) {
        input();
        exercise();
        System.out.println(m);
    }

    static void input() {
        n = sc.nextInt();
        costs = new long[n];

        for(int idx = 0; idx < n; idx++) {
            costs[idx] = sc.nextLong();
        }

        Arrays.sort(costs);
        m = Long.MIN_VALUE;
    }

    static void exercise() {
        if(n % 2 == 1) {
            m = costs[n - 1];
            n--;
        }

        for(int idx = 0; idx < n / 2; idx++) {
            m = Math.max(m, costs[idx] + costs[n - idx - 1]);
        }
    }

}