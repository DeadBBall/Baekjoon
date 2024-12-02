import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m, t, ans;
    static PriorityQueue<Edge> edges;
    static int[] parents;

    public static void main(String[] args) {
        input();
        conquer();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();

        edges = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.c - o2.c;
            }
        });

        parents = new int[n + 1];

        for(int idx = 0; idx < m; idx++) {
            edges.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        for(int idx = 1; idx <= n; idx++) {
            parents[idx] = idx;
        }
    }

    static void conquer() {
        int cnt = 0;
        int addCost = 0;

        while(cnt < n - 1) {
            Edge now = edges.remove();

            now.a = find(now.a);
            now.b = find(now.b);

            if(now.a != now.b) {
                union(now.a, now.b);

                ans += now.c + addCost;

                addCost += t;

                cnt++;
            }
        }
    }

    static int find(int x) {
        if(parents[x] == x) return x;

        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y) {
        if(x > y) {
            parents[x] = y;
        } else {
            parents[y] = x;
        }
    }
}

class Edge {
    int a;
    int b;
    int c;

    public Edge(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}