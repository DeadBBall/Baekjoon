import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static final int EMPTY = 0;
    static final int FIRST = 1;
    static final int SECOND = -1;
    static int v, e;
    static List<Integer>[] lines;
    static boolean[] visit;
    static int[] statuses;
    static boolean ans;

    public static void main(String[] args) {
        int k = sc.nextInt();
        while(k-- > 0) {
            input();
            divideGraph();
            System.out.println(ans ? "YES" : "NO");
        }

    }

    static void input() {
        v = sc.nextInt();
        e = sc.nextInt();
        lines = new ArrayList[v + 1];
        visit = new boolean[v + 1];
        statuses = new int[v + 1];
        ans = true;

        for(int lineIdx = 1; lineIdx <= v; lineIdx++) {
            lines[lineIdx] = new ArrayList<>();
        }

        for(int eIdx = 0; eIdx < e; eIdx++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            lines[start].add(end);
            lines[end].add(start);
        }

    }

    static void divideGraph() {
        for(int nodeIdx = 1; nodeIdx <= v; nodeIdx++) {
            if(!visit[nodeIdx]) {
                bfs(nodeIdx);
                if(!ans) return;
            }
        }
//        for(int i = 1; i <= v; i++) {
//            System.out.println(statuses[i]);
//        }
    }

    static void bfs(int start) {
        Queue<Integer> nodeQueue = new LinkedList<>();
        nodeQueue.add(start);

        while(!nodeQueue.isEmpty()) {
            int now = nodeQueue.remove();
            visit[now] = true;
            List<Integer> nowLine = lines[now];

            for(int lineIdx = 0; lineIdx < nowLine.size(); lineIdx++) {
                int end = nowLine.get(lineIdx);
//                System.out.println(now + " " + statuses[now] + " " + end + " " + statuses[end]);

                if(statuses[now] == EMPTY) {
                    if(statuses[end] != EMPTY)
                        statuses[now] = -statuses[end];
                    else
                        nodeQueue.add(end);
                } else {
                    if(statuses[end] == EMPTY) {
                        statuses[end] = -statuses[now];
                        nodeQueue.add(end);
                    } else if(statuses[now] == statuses[end]) {
                        ans = false;
                        return;
                    }
                }
//                System.out.println(now + " " + statuses[now] + " " + end + " " + statuses[end]);
//                System.out.println();
            }
            if(statuses[now] == EMPTY) statuses[now] = FIRST;

        }
    }

}