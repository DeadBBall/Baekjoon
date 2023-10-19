import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static int[] logs;
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {
        int t = sc.nextInt();
        while(t-- > 0) {
            input();
            compareHeights();
        }
        System.out.print(ansMaker);
    }
    static void input() {
        n = sc.nextInt();
        logs = new int[n];
        ans = 0;

        for(int logIdx = 0; logIdx < n; logIdx++) {
            logs[logIdx] = sc.nextInt();
        }
        Arrays.sort(logs);
    }

    static void compareHeights() {
        Deque<Integer> logDeque = new ArrayDeque<>();

        for(int logIdx = 0; logIdx < n; logIdx++) {
            if(logIdx % 2 == 0)
                logDeque.addFirst(logs[logIdx]);
            else
                logDeque.addLast(logs[logIdx]);
        }
        ans = Math.abs(logDeque.getFirst() - logDeque.getLast());

        int first = logDeque.removeFirst();

        while(!logDeque.isEmpty()) {
            int second = logDeque.removeFirst();
            ans = Math.max(ans, Math.abs(first - second));
            first = second;
        }
        ansMaker.append(ans + "\n");
    }

}