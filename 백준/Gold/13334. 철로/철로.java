import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, d, ans;
    static Edge[] edges;

    public static void main(String[] args) {
        input();
        connectTrack();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        edges = new Edge[n];

        for(int edgeIdx = 0; edgeIdx < n; edgeIdx++) {
            int left = sc.nextInt();
            int right = sc.nextInt();

            if(left > right) {
                int tmp = left;
                left = right;
                right = tmp;
            }

            edges[edgeIdx] = new Edge(left, right);
        }

        d = sc.nextInt();

        Arrays.sort(edges);
    }

    static void connectTrack() {
        PriorityQueue<Edge> edgePQ = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                if(o1.left == o2.left) return o1.right - o2.right;

                return o1.left - o2.left;
            }
        });

        for(int edgeIdx = 0; edgeIdx < n; edgeIdx++) {
            if(edges[edgeIdx].dist > d) continue;

            while(!edgePQ.isEmpty() && edges[edgeIdx].right - edgePQ.peek().left > d) {
                edgePQ.remove();
            }

            edgePQ.add(edges[edgeIdx]);

            ans = Math.max(ans, edgePQ.size());
        }
    }
}

class Edge implements Comparable{
    int left;
    int right;
    int dist;

    public Edge(int left, int right) {
        this.left = left;
        this.right = right;
        this.dist = right - left;
    }


    @Override
    public int compareTo(Object o) {
        Edge edge = (Edge)o;

        if(edge.right == this.right) return this.left - edge.left;

        return this.right - edge.right;
    }
}