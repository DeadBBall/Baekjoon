import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static int[] in;
    static int[] costs;
    static PriorityQueue<Task> taskQueue;
    static List<Integer>[] edges;

    public static void main(String[] args) {
        input();
        doTasks();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        in = new int[n + 1];
        costs = new int[n + 1];
        edges = new ArrayList[n + 1];
        taskQueue = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getEndTime() - o2.getEndTime();
            }
        });

        for(int taskIdx = 1; taskIdx <= n; taskIdx++) {
            int cost = sc.nextInt();
            costs[taskIdx] = cost;
            edges[taskIdx] = new ArrayList<>();

            int inCount = sc.nextInt();
            in[taskIdx] = inCount;

            if(inCount == 0) {
                taskQueue.add(new Task(taskIdx, cost, 0));
            }

            for(int inIdx = 0; inIdx < inCount; inIdx++) {
                int task = sc.nextInt();
                edges[task].add(taskIdx);
            }
        }
    }

    static void doTasks() {
        while(!taskQueue.isEmpty()) {
            Task now = taskQueue.remove();

            for(int out : edges[now.idx]) {
                in[out]--;

                if(in[out] == 0) {
                    taskQueue.add(new Task(out, costs[out], now.getEndTime()));
                }
            }
            ans = now.getEndTime();
        }
    }
}

class Task {
    int idx;
    int cost;
    int now;

    public Task(int idx, int cost, int now) {
        this.idx = idx;
        this.cost = cost;
        this.now = now;
    }

    public int getEndTime() {
        return cost + now;
    }
}