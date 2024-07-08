import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static long ans;
    static int[] parents;
    static PriorityQueue<Edge> edges;

    public static void main(String[] args) {
        input();
        connect();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        parents = new int[n + 1];

        for(int idx = 1; idx <= n; idx++) {
            parents[idx] = idx;
        }

        edges = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.cost - o2.cost;
            }
        });

        for(int start = 1; start <= n; start++) {
            for(int end = 1; end <= n; end++) {
                if(start == end) {
                    sc.nextInt();
                    continue;
                }

                int cost = sc.nextInt();

                edges.add(new Edge(start, end, cost));
            }
        }
    }

    static void connect() {
        int edgeCnt = 0;

        while(!edges.isEmpty() && edgeCnt < n - 1) {
            Edge now = edges.remove();

            now.start = find(now.start);
            now.end = find(now.end);

            if(now.start != now.end) {
                union(now.start, now.end);
                ans += now.cost;
                edgeCnt++;
            }
        }
    }

    static int find(int x) {
        if(x == parents[x]) return x;

        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y) {
        if(x == y) return;

        parents[x] = y;
    }

}

class Edge {
    int start;
    int end;
    int cost;

    public Edge(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}