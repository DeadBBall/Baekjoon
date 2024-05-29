import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, l, r, x, ans;
    static int[] problems;

    public static void main(String[] args) {
        input();
        pickProblems(0, 0, 0, 0, 0);
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();
        x = sc.nextInt();
        problems = new int[n];

        for(int problemIdx = 0; problemIdx < n; problemIdx++) {
            problems[problemIdx] = sc.nextInt();
        }

        Arrays.sort(problems);
    }

    static void pickProblems(int sum, int low, int high, int now, int cnt) {
        if(sum > r) return;

        if(now == n) {
            if(cnt >= 2 && sum >= l && high - low >= x) ans++;
            return;
        }

        pickProblems(sum + problems[now], low == 0 ? problems[now] : low, problems[now], now + 1, cnt + 1);
        pickProblems(sum, low, high, now + 1, cnt);
    }

}