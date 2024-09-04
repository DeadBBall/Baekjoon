import java.util.Scanner;

public class Main {
    static final int LEFT = 1;
    static Scanner sc = new Scanner(System.in);
    static int n, max, min;
    static int[] sums;

    public static void main(String[] args) {
        input();
        System.out.println(Math.max(Math.max(max, max - min), Math.abs(min)));
    }

    static void input() {
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        n = sc.nextInt();
        sums = new int[n + 1];

        for(int idx = 1; idx <= n; idx++) {
            int drct = sc.nextInt();

            if(drct == LEFT) {
                sums[idx] = sums[idx - 1] + 1;
            } else {
                sums[idx] = sums[idx - 1] - 1;
            }

            max = Math.max(max, sums[idx]);
            min = Math.min(min, sums[idx]);
        }
    }
}