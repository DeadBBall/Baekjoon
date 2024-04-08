import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static List<Edge>[] edges;
    static int[] in, dp;

    public static void main(String[] args) {
        input();
        assembleToy();
        for(int idx = 1; idx < n; idx++) {
            if(edges[idx].isEmpty()) {
                System.out.println(idx + " " + dp[idx]);
            }
        }
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();

        edges = new ArrayList[n + 1];
        in = new int[n + 1];
        dp = new int[n + 1];

        for(int edgeIdx = 1; edgeIdx <= n; edgeIdx++) {
            edges[edgeIdx] = new ArrayList<>();
        }

        while(m-- > 0) {
            int end = sc.nextInt();
            int start = sc.nextInt();
            int count = sc.nextInt();

            in[start]++;
            edges[end].add(new Edge(start, count));
        }
    }

    static void assembleToy() {
        Queue<Integer> partQueue = new LinkedList<>();
        partQueue.add(n);
        dp[n] = 1;

        while(!partQueue.isEmpty()) {
            int end = partQueue.remove();

            for(Edge now : edges[end]) {
                dp[now.start] += dp[end] * now.count;
                in[now.start]--;

                if(in[now.start] == 0) partQueue.add(now.start);
            }
        }
    }
}

class Edge {
    int start;
    int count;

    public Edge(int start, int count) {
        this.start = start;
        this.count = count;
    }
}