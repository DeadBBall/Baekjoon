import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int[] costs;
    static boolean[][] visit;
    static boolean isPossible;

    public static void main(String[] args) {
        input();
        goGym(0, 0);
        System.out.println(isPossible ? "YES" : "NO");
    }

    static void input() {
        n = sc.nextInt();
        costs = new int[n];

        for(int idx = 0; idx < n; idx++) {
            costs[idx] = sc.nextInt();
        }

        visit = new boolean[n][7];
    }

    static void goGym(int idx, int day) {
        if(day % 7 == 4) {
            isPossible = true;
            return;
        }

        if(idx == n) return;

        int nextDay = (day + costs[idx]) % 7;

        if(!visit[idx][nextDay] && !isPossible) {
            visit[idx][nextDay] = true;

            goGym(idx + 1, nextDay);
        }

        if(!visit[idx][day] && !isPossible) {
            visit[idx][day] = true;

            goGym(idx + 1, day);
        }
    }
}