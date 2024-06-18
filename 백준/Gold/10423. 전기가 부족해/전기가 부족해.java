import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m, k, ans;
    static PriorityQueue<Edge> edges;
    static int[] parents;

    public static void main(String[] args){
        input();
        installCables();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        parents = new int[n + 1];

        for(int node = 1; node <= n; node++) {
            parents[node] = node;
        }

        while(k-- > 0) {
            int node = sc.nextInt();

            parents[node] = 0;
        }

        edges = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.w - o2.w;
            }
        });

        while(m-- > 0) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            edges.add(new Edge(u, v, w));
        }
    }

    static void installCables() {
        while(!edges.isEmpty()) {
            Edge now = edges.remove();

            now.u = find(now.u);
            now.v = find(now.v);

            if(now.u != now.v) {
                union(now.u, now.v);
                ans += now.w;
            }

            if(checkAll()) break;
        }
    }

    static int find(int x) {
        if(x == 0) return x;

        else if(x == parents[x]) return x;

        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(y == 0) {
            parents[x] = y;
        } else {
            parents[y] = x;
        }
    }

    static boolean checkAll() {
        for(int node = 1; node <= n; node++) {
            if(parents[node] != 0) return false;
        }

        return true;
    }

}

class Edge {
    int u;
    int v;
    int w;

    Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}