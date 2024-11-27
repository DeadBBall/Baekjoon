import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static Edge[] edges;

    public static void main(String[] args) {
        input();
        paintEdge();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        edges = new Edge[n];

        for(int idx = 0; idx < n; idx++) {
            edges[idx] = new Edge(sc.nextInt(), sc.nextInt());
        }
    }

    static void paintEdge() {
        int left = edges[0].x;
        int right = edges[0].y;

        for(int idx = 0; idx < n; idx++) {
            if(edges[idx].x <= right) {
                right = Math.max(right, edges[idx].y);
            } else {
                ans += right - left;

                left = edges[idx].x;
                right = edges[idx].y;
            }

            if(idx == n - 1) {
                ans += right - left;
            }
        }
    }

}

class Edge {
    int x;
    int y;

    public Edge(int x, int y) {
        this.x = x;
        this.y = y;
    }
}