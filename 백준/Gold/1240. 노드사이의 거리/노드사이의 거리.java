import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static List<Edge>[] edges;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        measureDistance();
        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();

        edges = new List[n + 1];
        for(int edgeIdx = 1; edgeIdx <= n; edgeIdx++) {
            edges[edgeIdx] = new ArrayList<>();
        }


        for(int edgeIdx = 0; edgeIdx < n - 1; edgeIdx++) {
            int node = sc.nextInt();
            int node2 = sc.nextInt();
            int dist = sc.nextInt();

            edges[node].add(new Edge(node, node2, dist));
            edges[node2].add(new Edge(node2, node, dist));
        }


        ansMaker = new StringBuilder();
    }

    static void measureDistance() {
        while(m-- > 0) {
            int node = sc.nextInt();
            int node2 = sc.nextInt();

            dfs(node, node2, 0, new boolean[n + 1]);
        }
    }

    static boolean dfs(int now, int target, int dist, boolean[] visit) {
        visit[now] = true;

        if(now == target) {
            ansMaker.append(dist).append("\n");
            return true;
        }

        for(Edge edge : edges[now]) {
            if(visit[edge.end]) continue;

            if(dfs(edge.end, target, dist + edge.dist, visit)) return true;
        }

        return false;
    }

}

class Edge {
    int start;
    int end;
    int dist;

    public Edge(int start, int end, int dist) {
        this.start = start;
        this.end = end;
        this.dist = dist;
    }
}