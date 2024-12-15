import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m, ans;
    static int[] snow;

    public static void main(String[] args) {
        input();
        rollSnowball(-1, 1, 0);
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        snow = new int[n];

        for(int idx = 0; idx < n; idx++) {
            snow[idx] = sc.nextInt();
        }
    }

    static void rollSnowball(int idx, int size, int time) {
        if(idx == n - 1 || time == m) {
            ans = Math.max(ans, size);
            return;
        }

        rollSnowball(idx + 1, size + snow[idx + 1], time + 1);

        if(idx + 2 < n) {
            rollSnowball(idx + 2, size / 2 + snow[idx + 2], time + 1);
        }
    }

}