import java.util.*;

public class Main {
    static final int INF = 123456789;
    static Scanner sc = new Scanner(System.in);
    static List<Integer> footboards;
    static int[][][] dp;
    static int n;

    public static void main(String[] args) {
        input();
        System.out.println(playDDR(0, 0, 0));
    }

    static void input() {
        footboards = new ArrayList<>();
        int footboard = sc.nextInt();

        while(footboard != 0) {
            footboards.add(footboard);
            footboard = sc.nextInt();
        }

        n = footboards.size();
        dp = new int[n][5][5];

        for(int i = 0; i < n; i++) {
            for(int left = 0; left < 5; left++){
                for(int right = 0; right < 5; right++) {
                    dp[i][left][right] = INF;
                }
            }
        }
    }

    static int playDDR(int left, int right, int idx) {
        if(idx == n) return 0;
//        System.out.println("left: " + left + " right: " + right + " idx: " + idx + " power: " + dp[idx][left][right]);

        if(dp[idx][left][right] != INF) return dp[idx][left][right];

        int target = footboards.get(idx);

        dp[idx][left][right] = Math.min(playDDR(target, right, idx + 1) + measurePower(left, target),
                playDDR(left, target, idx + 1) + measurePower(right, target));

        return dp[idx][left][right];
    }

    static int measurePower(int now, int target) {
        if(now == 0) return 2;

        int diff = Math.abs(now - target);

        if(diff % 2 == 1) return 3;

        return diff == 0 ? 1 : 4;
    }

}