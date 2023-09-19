import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static final int INF = 1000000000;
    static int n;
    static Taste[] tastes;
    static int ans;

    public static void main(String[] args) {
        input();
        cook(0, 0, 1, 0);
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        tastes = new Taste[n];
        ans = INF;

        for(int tasteIdx = 0; tasteIdx < n; tasteIdx++) {
            int sour = sc.nextInt();
            int bitter = sc.nextInt();
            tastes[tasteIdx] = new Taste(sour, bitter);
        }
    }

    static void cook(int idx, int bitterResult, int sourResult, int count) {
        if(idx >= 1 && count >= 1) {
            ans = Math.min(ans, Math.abs(bitterResult - sourResult));
        }

        if(idx == n) return;

        cook(idx + 1, bitterResult + tastes[idx].bitter, sourResult * tastes[idx].sour, count + 1);
        cook(idx + 1, bitterResult, sourResult, count);
    }

    static class Taste {
        int bitter;
        int sour;

        public Taste(int sour, int bitter) {
            this.bitter = bitter;
            this.sour = sour;
        }
    }

}