import java.awt.print.Pageable;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int t;
    static int[] scores;
    static int[] times;
    static int[][] dp;

    public static void main(String[] args) {
        input();
        study();
        print();
    }

    static void input() {
        n = sc.nextInt();
        t = sc.nextInt();

        times = new int[n];
        scores = new int[n];
        dp = new int[n + 1][t + 1];

        for(int idx = 0; idx < n; idx++) {
            times[idx] = sc.nextInt();
            scores[idx] = sc.nextInt();
        }
    }

    static void study() {
        for(int idx = 0; idx < n; idx++) {
            int nowScore = scores[idx];
            int nowTime = times[idx];

            for(int time = 0; time <= t; time++) {

                if(times[idx] <= time) {
                    dp[idx + 1][time] = Math.max(dp[idx][time], dp[idx][time - nowTime] + nowScore);
                } else {
                    dp[idx + 1][time] = dp[idx][time];
                }

            }

        }
    }

    static void print() {
        System.out.println(dp[n][t]);
    }

}
