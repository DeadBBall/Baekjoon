import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, k;
    static int[][] dp;
    static Route[] walk, bike;

    public static void main(String[] args) {
        input();
        System.out.println(trip(0, 0));
    }

    static void input() {
        n = sc.nextInt();
        k = sc.nextInt();
        walk = new Route[n];
        bike = new Route[n];

        for(int idx = 0; idx < n; idx++) {
            walk[idx] = new Route(sc.nextInt(), sc.nextInt());
            bike[idx] = new Route(sc.nextInt(), sc.nextInt());
        }

        dp = new int[n][k + 1];
    }

    static int trip(int idx, int totalTime) {
        if(totalTime > k) return -123456789;

        if(idx == n) return 0;

        if(dp[idx][totalTime] != 0) return dp[idx][totalTime];

        dp[idx][totalTime] += Math.max(trip(idx + 1, totalTime + bike[idx].time) + bike[idx].money,
                trip(idx + 1, totalTime + walk[idx].time) + walk[idx].money);

        return dp[idx][totalTime];
    }

}

class Route {
    int time;
    int money;

    public Route(int time, int money) {
        this.time = time;
        this.money = money;
    }
}