import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int[] dist, prev;
    static int n, m;
    static List<Edge>[] edges;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        restore();
        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();

        edges = new List[n + 1];
        dist = new int[n + 1];
        prev = new int[n + 1];

        for(int nodeIdx = 1; nodeIdx <= n; nodeIdx++) {
            edges[nodeIdx] = new ArrayList<>();
            dist[nodeIdx] = 99999999;
        }

        while(m-- > 0) {
            int a = sc.nextInt();;
            int b = sc.nextInt();
            int c = sc.nextInt();

            edges[a].add(new Edge(b, c));
            edges[b].add(new Edge(a, c));
        }

        ansMaker = new StringBuilder();
    }

    static void restore() {
        PriorityQueue<Edge> edgePQ = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.dist - o2.dist;
            }
        });

        edgePQ.add(new Edge(1, 0));
        dist[1] = 0;

        while(!edgePQ.isEmpty()) {
            Edge now = edgePQ.remove();

            for(Edge next : edges[now.end]) {
                if(dist[next.end] > dist[now.end] + next.dist) {
                    dist[next.end] = dist[now.end] + next.dist;
                    prev[next.end] = now.end;
                    edgePQ.add(next);
                }
            }
        }

        ansMaker.append(n - 1).append("\n");

        for(int node = 2; node <= n; node++) {
            ansMaker.append(node).append(" ").append(prev[node]).append("\n");
        }
    }
}

class Edge {
    int end;
    int dist;

    Edge(int end, int dist) {
        this.end = end;
        this.dist = dist;
    }
}