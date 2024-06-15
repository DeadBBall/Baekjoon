import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static final int SOURCE = 1;
    static final int SINK = 26;
    static final int MAX_SIZE = 70;
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static int[][] capacity;
    static int[][] flow;
    static int[] parent;

    public static void main(String[] args){
        input();
        maxFlow();
        System.out.println(ans);
    }

    static void input() {
        capacity = new int[MAX_SIZE][MAX_SIZE];
        flow = new int[MAX_SIZE][MAX_SIZE];
        parent = new int[MAX_SIZE];

        n = sc.nextInt();

        while(n-- > 0) {
            String start = sc.next();
            String end = sc.next();
            int volume = sc.nextInt();

            capacity[start.charAt(0) - 64][end.charAt(0) - 64] += volume;
            capacity[end.charAt(0) - 64][start.charAt(0) - 64] += volume;
        }
    }

    static void maxFlow() {
        Queue<Integer> nodeQueue = new LinkedList<>();

        while (true) {
            for (int idx = 0; idx < 70; idx++) {
                parent[idx] = -1;
            }

            parent[SOURCE] = SOURCE;
            nodeQueue.add(SOURCE);

            while (!nodeQueue.isEmpty()) {
                int now = nodeQueue.remove();

                for (int next = 0; next < 70; next++) {
                    if (capacity[now][next] > flow[now][next] && parent[next] == -1) {
                        nodeQueue.add(next);
                        parent[next] = now;

                        if (next == SINK) break;
                    }
                }
            }

            if (parent[SINK] == -1) break;

            int now = SINK;
            int minflow = Integer.MAX_VALUE;

            while (now != SOURCE) {
                int next = parent[now];
                int residualCapa = capacity[next][now] - flow[next][now];

                if (residualCapa > 0 && (minflow > residualCapa)) {
                    minflow = residualCapa;
                }

                now = parent[now];
            }
            now = SINK;

            while (now != SOURCE) {
                int next = parent[now];
                flow[next][now] += minflow;
                flow[now][next] -= minflow;
                now = parent[now];
            }

            ans += minflow;
        }
    }
}