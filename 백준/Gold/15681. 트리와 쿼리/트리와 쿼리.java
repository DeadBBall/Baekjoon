import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, r, q;
    static int[] dp;
    static List<Integer>[] edges;
    static boolean[] visit;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        countNode();
        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        r = sc.nextInt();
        q = sc.nextInt();

        dp = new int[n + 1];
        visit = new boolean[n + 1];
        edges = new List[n + 1];

        for(int idx = 1; idx <= n; idx++) {
            edges[idx] = new ArrayList<>();
        }

        for(int idx = 0; idx < n - 1; idx++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            edges[u].add(v);
            edges[v].add(u);
        }

        ansMaker = new StringBuilder();
        makeTree(r);
    }

    static int makeTree(int now) {
        visit[now] = true;

        if(dp[now] != 0) return dp[now];

        dp[now] = 1;

        for(int next : edges[now]) {
            if(visit[next]) continue;

            dp[now] += makeTree(next);
        }

        return dp[now];
    }

    static void countNode() {
        for(int idx = 0; idx < q; idx++) {
            int node = sc.nextInt();

            ansMaker.append(dp[node]).append("\n");
        }
    }
}