import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int m, n, ans;
    static int[] parents;
    static Edge[] edges;
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args){
        while(true) {
            input();
            if(m == 0) break;

            saveElectricity();
            ansMaker.append(ans).append("\n");
        }
        System.out.print(ansMaker);
    }

    static void input(){
        m = sc.nextInt();
        n = sc.nextInt();
        ans = 0;
        if(m == 0) return;

        parents = new int[m];
        for(int nodeIdx = 0; nodeIdx < m; nodeIdx++) {
            parents[nodeIdx] = nodeIdx;
        }

        edges = new Edge[n];
        for(int edgeIdx = 0; edgeIdx < n; edgeIdx++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

           edges[edgeIdx] = new Edge(x, y, z);
           ans += z;
        }

        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.dist - o2.dist;
            }
        });
    }

    static void saveElectricity() {
        int edgeCount = 0;

        for(int edgeIdx = 0; edgeIdx < n; edgeIdx++) {
            if(edgeCount == n - 1) break;

            Edge now = edges[edgeIdx];

            int startParent = find(now.start);
            int endParent = find(now.end);

            if(startParent == endParent) continue;

            union(startParent, endParent);
            edgeCount++;
            ans -= now.dist;
        }
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