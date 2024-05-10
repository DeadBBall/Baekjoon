import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static int[] parents;
    static Position[] gods;
    static PriorityQueue<Edge> edges;
    static double ans;

    public static void main(String[] args) {
        input();
        connectGods();
        System.out.println(String.format("%.2f", ans));
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        gods = new Position[n + 1];
        parents = new int[n + 1];
        edges = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Double.compare(o1.dist, o2.dist);
            }
        });

        for(int idx = 1; idx <= n; idx++) {
            long x = sc.nextLong();
            long y = sc.nextLong();

            gods[idx] = new Position(y, x);
            parents[idx] = idx;
        }

        for(int start = 1; start < n; start++) {
            for(int end = start + 1; end <= n; end++) {
                edges.add(new Edge(start, end, calculateDist(start, end)));
            }
        }

        for(int idx = 0; idx < m; idx++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            union(x, y);
        }
    }

    static double calculateDist(int start, int end) {
        return Math.sqrt(Math.pow(gods[start].x - gods[end].x, 2)
                + Math.pow(gods[start].y - gods[end].y, 2));
    }

    static int find(int x) {
        if(parents[x] == x) return x;

        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) return;

        parents[x] = y;
    }

    static void connectGods() {
        while(!edges.isEmpty()) {
            Edge now = edges.remove();

            int x = find(now.start);
            int y = find(now.end);

            if(x == y) continue;

            union(x, y);

            ans += now.dist;
        }
    }
}

class Position {
    long y;
    long x;

    Position(long y, long x) {
        this.y = y;
        this.x = x;
    }
}

class Edge {
    int start;
    int end;
    double dist;

    Edge(int start, int end, double dist) {
        this.start = start;
        this.end = end;
        this.dist = dist;
    }
}