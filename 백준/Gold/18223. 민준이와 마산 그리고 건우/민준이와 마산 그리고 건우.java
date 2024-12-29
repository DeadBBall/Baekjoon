import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int v, e, p;
    static List<Edge>[] edges;
    static int[][] dists;

    public static void main(String[] args) {
        input();
        move(1, 0);
        move(p, 1);
        System.out.println(dists[0][v] == dists[0][p] + dists[1][v] ? "SAVE HIM" : "GOOD BYE");
    }

    static void input() {
        v = sc.nextInt();
        e = sc.nextInt();
        p = sc.nextInt();
        edges = new List[v + 1];
        dists = new int[2][v + 1];

        for(int idx = 1; idx <= v; idx++) {
            edges[idx] = new ArrayList<>();
        }

        for(int idx = 0; idx < 2; idx++) {
            Arrays.fill(dists[idx], 987_654_321);
        }

        while(e-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            edges[a].add(new Edge(b, c));
            edges[b].add(new Edge(a, c));
        }
    }

    static void move(int start, int pos) {
        Queue<Integer> nodes = new LinkedList<>();
        nodes.add(start);

        dists[pos][start] = 0;

        while(!nodes.isEmpty()) {
            int now = nodes.remove();

            for(Edge next : edges[now]) {
                if(dists[pos][now] + next.dist < dists[pos][next.end]) {
                    dists[pos][next.end] = dists[pos][now] + next.dist;
                    nodes.add(next.end);
                }
            }
        }
    }
}

class Edge {
    int end;
    int dist;

    public Edge(int end, int dist) {
        this.end = end;
        this.dist = dist;
    }
}