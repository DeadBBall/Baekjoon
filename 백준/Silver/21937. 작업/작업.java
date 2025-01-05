import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m, x, ans;
    static List<Integer>[] edges;
    static boolean[] visit;

    public static void main(String[] args) {
        input();
        work(x);
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        edges = new List[n + 1];
        visit = new boolean[n + 1];

        for(int idx = 1; idx <= n; idx++) {
            edges[idx] = new ArrayList<>();
        }

        while(m-- > 0) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            edges[end].add(start);
        }

        x = sc.nextInt();
    }

    static void work(int now) {
        for(int next : edges[now]) {
            if(visit[next]) continue;

            visit[next] = true;

            ans++;

            work(next);
        }
    }
}