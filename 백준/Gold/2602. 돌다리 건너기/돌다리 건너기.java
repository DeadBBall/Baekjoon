import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String target, devil, angel;
    static int[][][] dp;

    public static void main(String[] args) {
        input();
        System.out.println(crossStoneBridge(0, 0, 0)
                + crossStoneBridge(0, 0, 1));
    }

    static void input() {
        target = sc.next();
        devil = sc.next();
        angel = sc.next();

        dp = new int[target.length() + 1][devil.length() + 1][2];

        for(int tIdx = 0; tIdx <= target.length(); tIdx++) {
            for(int sIdx = 0; sIdx <= devil.length(); sIdx++) {
                Arrays.fill(dp[tIdx][sIdx], -1);
            }
        }
    }

    static int crossStoneBridge(int targetIdx, int nowStone, int turn) {
        if(targetIdx == target.length()) return 1;

        if(dp[targetIdx][nowStone][turn] != -1) return dp[targetIdx][nowStone][turn];

        int result = 0;

        if(turn == 0) {
            for(int stoneIdx = nowStone; stoneIdx < devil.length(); stoneIdx++) {
                if(target.charAt(targetIdx) == devil.charAt(stoneIdx)) {
                    result += crossStoneBridge(targetIdx + 1, stoneIdx + 1, 1);
                }
            }
        }
        else {
            for(int stoneIdx = nowStone; stoneIdx < angel.length(); stoneIdx++) {
                if(target.charAt(targetIdx) == angel.charAt(stoneIdx)) {
                    result += crossStoneBridge(targetIdx + 1, stoneIdx + 1, 0);
                }
            }
        }

        return dp[targetIdx][nowStone][turn] = result;
    }

}