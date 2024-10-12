import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int cnt;
    static Brick[] bricks;
    static int[] dp;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        buildTower();
        System.out.print(ansMaker);
    }

    static void input() {
        cnt = sc.nextInt();
        bricks = new Brick[cnt];

        for(int idx = 0; idx < cnt; idx++) {
            bricks[idx] = new Brick(idx + 1, sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(bricks, new Comparator<Brick>() {
            @Override
            public int compare(Brick o1, Brick o2) {
                return o2.length - o1.length;
            }
        });

        dp = new int[cnt + 1];

        ansMaker = new StringBuilder();
    }

    static void buildTower() {
        int max = dp[0] = bricks[0].height;

        for(int i = 1; i < cnt; i++) {
            dp[i] = bricks[i].height;

            for(int j = i - 1; j >= 0; j--) {

                if(bricks[j].weight > bricks[i].weight) {
                    dp[i] = Math.max(dp[j] + bricks[i].height, dp[i]);
                }
            }

            max = Math.max(dp[i], max);
        }

        int ans = 0;

        for(int idx = cnt - 1; idx >= 0 && max != 0; idx--) {
            if(max == dp[idx]) {
                max -= bricks[idx].height;
                ans++;
                ansMaker.append(bricks[idx].idx).append("\n");
            }
        }

        ansMaker.insert(0, ans + "\n");
    }

}

class Brick {
    int idx;
    int length;
    int height;
    int weight;

    public Brick(int idx, int length, int height, int weight) {
        this.idx = idx;
        this.length = length;
        this.height = height;
        this.weight = weight;
    }
}