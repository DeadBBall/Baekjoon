import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int[] parents;
    static int n;
    static int[][] edges;

    public static void main(String[] args) {
        input();
        buildBridge();
    }

    static void input() {
        n = sc.nextInt();
        parents = new int[n + 1];

        for(int island = 1; island <= n; island++) {
            parents[island] = island;
        }

        edges = new int[n - 2][2];

        for(int edgeIdx = 0; edgeIdx < n - 2; edgeIdx++) {
            int island = sc.nextInt();
            int island2 = sc.nextInt();

            edges[edgeIdx][0] = island;
            edges[edgeIdx][1] = island2;
        }
    }

    static void buildBridge() {
        for(int idx = 0; idx < 2; idx++) {
            for (int edgeIdx = 0; edgeIdx < n - 2; edgeIdx++) {
                union(edges[edgeIdx][0], edges[edgeIdx][1]);
            }
        }

        int ans = -1;
        int ans2 = -1;

        for(int island = 1; island <= n; island++) {
            if(ans == -1) {
                ans = parents[island];
            } else if(ans != parents[island]) {
                ans2 = parents[island];
                break;
            }
        }
        
        System.out.println(ans + " " + ans2);
    }

    static int find(int x) {
        if(parents[x] == x) return x;

        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x > y) {
            parents[x] = y;
        } else if(x < y) {
            parents[y] = x;
        }
    }
}