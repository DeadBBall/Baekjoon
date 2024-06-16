import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static List<Edge>[] edges;
    static int[][] dists;
    static int robot, robot2;

    public static void main(String[] args){
        input();
        findMin();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        edges = new List[n + 1];
        robot = sc.nextInt();
        robot2 = sc.nextInt();

        for(int nodeIdx = 1; nodeIdx <= n; nodeIdx++) {
            edges[nodeIdx] = new ArrayList<>();
        }

        for(int idx = 0; idx < n - 1; idx++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int dist = sc.nextInt();

            edges[start].add(new Edge(end, dist));
            edges[end].add(new Edge(start, dist));
        }

        dists = new int[n + 1][2];
        ans = Integer.MAX_VALUE;
    }

    static void findMin() {
        if(robot == robot2 || n == 1) {
            ans = 0;
            return;
        }

        bfs(robot, 0);
        bfs(robot2, 1);

        Queue<Integer> nodeQueue = new LinkedList<>();
        nodeQueue.add(robot);

        boolean[] visit = new boolean[n + 1];
        visit[robot] = true;

        while(!nodeQueue.isEmpty()) {
            int now = nodeQueue.remove();

            for(Edge next : edges[now]) {
                if(visit[next.end]) continue;

                visit[next.end] = true;

                ans = Math.min(ans,
                        Math.min(dists[next.end][0] + dists[now][1], dists[now][0] + dists[next.end][1]));

                nodeQueue.add(next.end);
            }
        }
    }

    static void bfs(int start, int idx) {
        Queue<Integer> nodeQueue = new LinkedList<>();
        nodeQueue.add(start);

        boolean[] visit = new boolean[n + 1];
        visit[start] = true;

        while(!nodeQueue.isEmpty()) {
            int now = nodeQueue.remove();

            for(Edge next : edges[now]) {
                if(visit[next.end]) continue;

                visit[next.end] = true;

                dists[next.end][idx] = dists[now][idx] + next.dist;

                nodeQueue.add(next.end);
            }
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