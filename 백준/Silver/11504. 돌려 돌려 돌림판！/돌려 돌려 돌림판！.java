import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m, x, y;
    static int[] roulette;
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {
        int t = sc.nextInt();

        while(t-- > 0) {
            input();
            spinRoulette();
        }

        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();

        x = 0;
        y = 0;

        for(int idx = 0; idx < m; idx++) {
            x *= 10;
            x += sc.nextInt();
        }

        for(int idx = 0; idx < m; idx++) {
            y *= 10;
            y += sc.nextInt();
        }

        roulette = new int[n];

        for(int idx = 0; idx < n; idx++) {
            roulette[idx] = sc.nextInt();
        }
    }

    static void spinRoulette() {
        int ans = 0;
        int now = 0;
        int mod = (int)Math.pow(10, m - 1);

        for(int idx = 0; idx < n + m - 1; idx++) {
            if(idx >= m) {
                now -= roulette[(idx - m) % n] * mod;
            }

            now = now * 10 + roulette[idx % n];

            if(idx >= m - 1 && now >= x && now <= y) ans++;
        }

        ansMaker.append(ans).append("\n");
    }

}