import java.util.*;

public class Main {
    static final int INF = 987654321;
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static Set<Integer> smallStones;
    static int[][] dp;

    public static void main(String[] args) {
        input();
        int ans = jump(1, 0);
        System.out.println(ans == INF ? -1 : ans);
    }


    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        smallStones = new HashSet<>();

        while(m-- > 0) {
            smallStones.add(sc.nextInt());
        }

        smallStones.add(0);
        smallStones.add(1);

        dp = new int[n + 1][(int)Math.sqrt(2 * n) + 2];

        for(int idx = 0; idx < n + 1; idx++) {
            Arrays.fill(dp[idx], -1);
        }
    }

    static int jump(int idx, int speed) {
        if(idx == n) return 0;

        if(idx > n) return INF;

        if(dp[idx][speed] != -1) return dp[idx][speed];

        dp[idx][speed] = INF;

        if(!smallStones.contains(idx + speed + 1)) {
            dp[idx][speed] = Math.min(dp[idx][speed], jump(idx + speed + 1, speed + 1) + 1);
        }

        if(!smallStones.contains(idx + speed)) {
            dp[idx][speed] = Math.min(dp[idx][speed], jump(idx + speed, speed) + 1);
        }

        if(!smallStones.contains(idx + speed - 1) && speed >= 1) {
            dp[idx][speed] = Math.min(dp[idx][speed], jump(idx + speed - 1, speed - 1) + 1);
        }

        return dp[idx][speed];
    }
}