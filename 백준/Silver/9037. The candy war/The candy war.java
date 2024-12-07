import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int[] candies;
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {
        int t = sc.nextInt();

        while(t-- > 0) {
            input();
            shareCandies();
        }

        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        candies = new int[n];

        for(int idx = 0; idx < n; idx++) {
            candies[idx] = sc.nextInt();

            if(candies[idx] % 2 == 1) candies[idx]++;
        }
    }

    static void shareCandies() {
        int cnt = 0;

        while(!isDone()) {
            circulate();
            cnt++;
        }

        ansMaker.append(cnt).append("\n");
    }

    static boolean isDone() {
        int cnt = candies[0];

        for(int idx = 1; idx < n; idx++) {
            if(cnt != candies[idx]) return false;
        }

        return true;
    }

    static void circulate() {
        int[] tmps = new int[n];

        for(int idx = 0; idx < n; idx++) {
            tmps[(idx + 1) % n] = candies[idx] / 2;
        }

        for(int idx = 0; idx < n; idx++) {
            candies[idx] /= 2;
            candies[idx] += tmps[idx];

            if(candies[idx] % 2 == 1) candies[idx]++;
        }
    }
}