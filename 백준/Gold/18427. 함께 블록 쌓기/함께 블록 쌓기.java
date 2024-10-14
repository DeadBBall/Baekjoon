import java.util.*;

public class Main {
    static final int MOD = 10007;
    static Scanner sc = new Scanner(System.in);
    static int n, m, h;
    static List<Integer>[] blocks;
    static int[][] dp;

    public static void main(String[] args) {
        input();
        buildBlock();
        System.out.println(dp[n][h]);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        h = sc.nextInt();
        blocks = new List[n + 1];
        dp = new int[n + 1][h + 1];

        sc.nextLine();

        for(int sIdx = 1; sIdx <= n; sIdx++) {
            String[] inputLine = sc.nextLine().split(" ");

            blocks[sIdx] = new ArrayList<>();

            for(int bIdx = 0; bIdx < inputLine.length; bIdx++) {
                blocks[sIdx].add(Integer.parseInt(inputLine[bIdx]));
            }
        }
    }

    static void buildBlock() {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= h; j++) {
                for(int block : blocks[i]) {
                    if(j == block) dp[i][j]++;

                    if(block <= j) {
                        dp[i][j] += dp[i - 1][j - block];
                    }
                }

                dp[i][j] += dp[i - 1][j];
                dp[i][j] %= MOD;
            }
        }
    }
}