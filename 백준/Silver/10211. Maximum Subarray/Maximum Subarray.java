import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker = new StringBuilder();
    static int n;
    static int[] sums;

    public static void main(String[] args) {
        int t = sc.nextInt();

        while(t-- > 0) {
            input();
            findMax();
        }

        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        sums = new int[n + 1];

        for(int idx = 1; idx <= n; idx++) {
            sums[idx] = sums[idx - 1] + sc.nextInt();
        }
    }

    static void findMax() {
        int ans = Integer.MIN_VALUE;

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                ans = Math.max(sums[i] - sums[j], ans);
            }
        }

        ansMaker.append(ans).append("\n");
    }

}