import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static final int INF = 100001;
    static int n;
    static int k;
    static int[] paths;
    static boolean[] visit;
    static int maxPos;
    static int minTime;

    public static void main(String[] args) {
        input();
        playHideAndSeek();
        printAns();
    }

    static void input() {
       n = sc.nextInt();
       k = sc.nextInt();
       maxPos = Math.max(n, k);

       paths = new int[INF];
       visit = new boolean[INF];
       visit[n] = true;
       minTime = INF;
    }

    static void playHideAndSeek() {
        PriorityQueue<Now> nowQueue = new PriorityQueue<>(new Comparator<Now>() {
            @Override
            public int compare(Now a, Now b) {
                return a.nowTime - b.nowTime;
            }
        });

        nowQueue.add(new Now(n, 0));

        while(!nowQueue.isEmpty()) {
            Now now = nowQueue.remove();
//            System.out.println(now.nowPos + " " + now.nowTime);

            if(now.nowPos == k) {
                minTime = now.nowTime;
                return;
            }

            if(canMove(now.nowPos * 2)) {
                visit[now.nowPos * 2] = true;
                paths[now.nowPos * 2] = now.nowPos;
//                paths[now.nowPos] = now.nowPos * 2;
                nowQueue.add(new Now(now.nowPos * 2, now.nowTime + 1));
            }

            if(canMove(now.nowPos + 1)) {
                visit[now.nowPos + 1] = true;
                paths[now.nowPos + 1] = now.nowPos;
//                paths[now.nowPos] = now.nowPos + 1;
                nowQueue.add(new Now(now.nowPos + 1, now.nowTime + 1));
            }

            if(canMove(now.nowPos - 1)) {
                visit[now.nowPos - 1] = true;
                paths[now.nowPos - 1] = now.nowPos;
//                paths[now.nowPos] = now.nowPos - 1;
                nowQueue.add(new Now(now.nowPos - 1, now.nowTime + 1));
            }

        }

    }

    static boolean canMove(int now) {
        return now >= 0 && now <= INF - 1 && !visit[now];
    }

    static void printAns() {
        StringBuilder ansMaker = new StringBuilder();
        ansMaker.append(minTime).append("\n");
        ansMaker.append(n + " ");
        Stack<Integer> stack = new Stack<>();

        while(n != k) {
            stack.add(k);
            k = paths[k];
        }

        while(!stack.isEmpty()) {
            ansMaker.append(stack.pop() + " ");
        }

        System.out.println(ansMaker);
    }

    static class Now {
        int nowPos;
        int nowTime;

        public Now(int nowPos, int nowTime) {
            this.nowPos = nowPos;
            this.nowTime = nowTime;
        }

    }


}