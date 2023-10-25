import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, z, m, k;
    static boolean[] obstacles;
    static boolean[] visit;

    public static void main(String[] args) {
        input();
        searchMinMove();
        System.out.println(k);
    }

    static void input() {
        n = sc.nextInt();
        z = sc.nextInt();
        m = sc.nextInt();
        obstacles = new boolean[n + 1];

        for(int idx = 0; idx < m; idx++) {
            int pos = sc.nextInt();
            obstacles[pos] = true;
        }
        k = 1;
    }

    static void searchMinMove() {
        if(m == 0) return;

        for(int move = 1; ;move++) {
            int now = 1;
            visit = new boolean[n + 1];
            visit[now] = true;
            while(true) {
                now = (now + move) % n;
                if(now == 0) now = n;
                if(now == z) {
                    k = move;
                    return;
                }
                if(obstacles[now] || visit[now]) break;
                visit[now] = true;
            }
        }
    }
}