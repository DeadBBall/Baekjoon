import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int[] parents;
    static int n, m, ans;
    static List<Edge> edges;

    public static void main(String[] args) {
        input();
        visit();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();

        parents = new int[n + 1];

        edges = new ArrayList<>();

        while (m-- > -1) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            edges.add(new Edge(a, b, c == 1));
        }
    }

    static void visit() {
        int min = 0;
        int max = 0;

        PriorityQueue<Edge> edgePQ = reset(true);

        max = countUphill(edgePQ);

        edgePQ = reset(false);

        min = countUphill(edgePQ);

        ans = max - min;
    }

    static PriorityQueue<Edge> reset(boolean type) {
        for (int nodeIdx = 0; nodeIdx <= n; nodeIdx++) {
            parents[nodeIdx] = nodeIdx;
        }

        PriorityQueue<Edge> edgePQ = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return type
                        ? Boolean.compare(o1.isDownhill, o2.isDownhill)
                        : Boolean.compare(o2.isDownhill, o1.isDownhill);
            }
        });

        edgePQ.addAll(edges);

        return edgePQ;
    }

    static int countUphill(PriorityQueue<Edge> edgePQ) {
        int edgeCnt = 0;
        int uphillCnt = 0;

        while (edgeCnt < n) {
            Edge now = edgePQ.remove();

            int x = find(now.start);
            int y = find(now.end);

            if (x != y) {
                union(x, y);
                edgeCnt++;

                if (!now.isDownhill) uphillCnt++;
            }
        }

        return uphillCnt * uphillCnt;
    }

    static int find(int x) {
        if (parents[x] == x) return x;

        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x > y) {
            parents[x] = y;
        } else if (x < y) {
            parents[y] = x;
        }
    }
}

class Edge {
    int start;
    int end;
    boolean isDownhill;

    public Edge(int start, int end, boolean isDownhill) {
        this.start = start;
        this.end = end;
        this.isDownhill = isDownhill;
    }
}