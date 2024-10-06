import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, q;
    static Log[] logs;
    static int[] parents;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        jump();
        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        q = sc.nextInt();

        logs = new Log[n];
        parents = new int[n + 1];
        for(int idx = 1; idx <= n; idx++) {
            logs[idx - 1] = new Log(sc.nextInt(), sc.nextInt(), sc.nextInt(), idx);
            parents[idx] = idx;
        }

        Arrays.sort(logs, new Comparator<Log>() {
            @Override
            public int compare(Log o1, Log o2) {
                if(o1.start == o2.start) return o1.end - o2.end;
                return o1.start - o2.start;
            }
        });

        ansMaker = new StringBuilder();
    }

    static void jump() {
        Log now = logs[0];

        for(int idx = 0; idx < n - 1; idx++) {
            if(now.start <= logs[idx + 1].start && logs[idx + 1].start <= now.end) {
                union(now.idx, logs[idx + 1].idx);

                if(now.end < logs[idx + 1].end) {
                    now.end = logs[idx + 1].end;
                }
            } else {
                now = logs[idx + 1];
            }
        }

        while(q-- > 0) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            if(parents[start] == parents[end]) {
                ansMaker.append(1);
            } else {
                ansMaker.append(0);
            }

            ansMaker.append("\n");
        }
    }

    static int find(int x) {
        if(x == parents[x]) return x;

        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) return;

        parents[y] = x;
    }
}

class Log {
    int start;
    int end;
    int y;
    int idx;

    public Log(int start, int end, int y, int idx) {
        this.start = start;
        this.end = end;
        this.y = y;
        this.idx = idx;
    }
}