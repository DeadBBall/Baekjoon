import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static boolean[] cycle;
    static List<Integer>[] edges;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        measureDistance();
        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        edges = new ArrayList[n + 1];
        cycle = new boolean[n + 1];

        for(int idx = 1; idx <= n; idx++) {
            edges[idx] = new ArrayList<>();
        }

        for(int idx = 0; idx < n; idx++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            edges[a].add(b);
            edges[b].add(a);
        }

        ansMaker = new StringBuilder();
    }

    static void measureDistance() {
        for(int idx = 1; idx <= n; idx++) {
            if(goNext(idx, idx, -1)) break;

            Arrays.fill(cycle, false);
        }

        for(int idx = 1; idx <= n; idx++) {
            if(cycle[idx]) {
                ansMaker.append(0).append(" ");
            }
            else {
                ansMaker.append(bfs(idx)).append(" ");
            }
        }
    }

    static boolean goNext(int start, int now, int parent) {
        cycle[now] = true;

        for(int next : edges[now]) {
            if(!cycle[next]) {
                if(goNext(start, next, now)) return true;
            } else if(next != parent && next == start) return true;
        }
        
        cycle[now] = false;

        return false;
    }

    static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        boolean[] visit = new boolean[n + 1];
        visit[start] = true;

        while(!queue.isEmpty()) {
            int now = queue.remove();

            for (int next : edges[now % 10000]) {
                if(cycle[next]) return (now / 10000) + 1;

                if(visit[next]) continue;

                visit[next] = true;

                queue.add(next + now / 10000 * 10000 + 10000);
            }
        }

        return 0;
    }
}