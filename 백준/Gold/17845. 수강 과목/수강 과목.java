import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, k, ans;
    static Subject[] subjects;
    static int[] dp;

    public static void main(String[] args) {
        input();
        study();
        System.out.println(dp[n]);
    }
    static void input() {
        n = sc.nextInt();
        k = sc.nextInt();
        subjects = new Subject[k];
        dp = new int[n + 1];

        for(int subIdx = 0; subIdx < k; subIdx++) {
            int importance = sc.nextInt();
            int time = sc.nextInt();

            subjects[subIdx] = new Subject(importance, time);
        }
    }

    static void study() {
        for(int subIdx = 0; subIdx < k; subIdx++) {
            for(int time = n; time >= subjects[subIdx].time; time--) {
                dp[time] = Math.max(dp[time], dp[time - subjects[subIdx].time] + subjects[subIdx].importance);
            }
        }
    }

    static class Subject {
        int importance;
        int time;

        Subject(int importance, int time) {
            this.importance = importance;
            this.time = time;
        }
    }
}