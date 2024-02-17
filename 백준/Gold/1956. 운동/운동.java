import java.util.*;

public class Main {
    static final int INF = 123456789;
    static int v, e, ans;
    static Scanner sc = new Scanner(System.in);
    static int[][] edges;

    public static void main(String[] args) {
        input();
        findCycle();
        System.out.println(ans == INF ? -1 : ans);
    }

    static void input() {
        v = sc.nextInt();
        e = sc.nextInt();
        ans = INF;

        edges = new int[v + 1][v + 1];
        for(int start = 1; start <= v; start++) {
            for(int end = 1; end <= v; end++) {
                edges[start][end] = INF;
            }
        }

        for(int edgeIdx = 0; edgeIdx < e; edgeIdx++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            edges[a][b] = c;
        }

    }

    static void findCycle() {
        for(int mid = 1; mid <= v; mid++) {
            for(int start = 1; start <= v; start++) {
                for(int end = 1; end <= v; end++) {
                    edges[start][end] = Math.min(edges[start][end], edges[start][mid] + edges[mid][end]);
                }
            }
        }

        for(int nodeIdx = 1; nodeIdx <= v; nodeIdx++) {
            ans = Math.min(edges[nodeIdx][nodeIdx], ans);
        }
    }
}