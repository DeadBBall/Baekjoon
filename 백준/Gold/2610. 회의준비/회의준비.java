import java.util.*;

public class Main {
    static final int INF = 987654321;
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static int[][] edges;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        formCommittee();
        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        edges = new int[n + 1][n + 1];

        for(int node = 1; node <= n; node++) {
            Arrays.fill(edges[node], INF);
        }

        while(m-- > 0) {
            int left = sc.nextInt();
            int right = sc.nextInt();

            edges[left][right] = 1;
            edges[right][left] = 1;
        }

        ansMaker = new StringBuilder();
    }

    static void formCommittee() {
        floydWarshall();

        boolean[] visit = new boolean[n + 1];
        List<Integer> answers = new ArrayList<>();

        for(int node = 1; node <= n; node++) {
            if(visit[node]) continue;

            answers.add(calculateMin(node, visit));
        }

        Collections.sort(answers);

        ansMaker.append(answers.size()).append("\n");
        answers.forEach(a -> ansMaker.append(a).append("\n"));
    }

    static void floydWarshall() {
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(i == j) continue;
                    edges[i][j] = Math.min(edges[i][j], edges[i][k] + edges[k][j]);
                }
            }
        }
    }

    static int calculateMin(int node, boolean[] visit) {
        visit[node] = true;

        List<Integer> members = new ArrayList<>();
        members.add(node);

        for(int end = node + 1; end <= n; end++) {
            if(edges[node][end] != INF) {
                members.add(end);
                visit[end] = true;
            }
        }

        int min = INF;
        int ans = node;

        for(int start : members) {
            int max = 0;

            for(int end : members) {
                if(edges[start][end] != INF) {
                    max = Math.max(max, edges[start][end]);
                }
            }

            if(min > max) {
                min = max;
                ans = start;
            }
        }

        return ans;
    }
}