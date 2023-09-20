import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int[] board;
    static boolean[] visit;
    static int ans;

    public static void main(String[] args) {
        input();
        jump();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        board = new int[n];
        ans = -1;
        visit = new boolean[n];

        for(int idx = 0; idx < n; idx++) {
            board[idx] = sc.nextInt();
        }
    }

    static void jump() {
        PriorityQueue<Jaehwan> jaehwanPriorityQueue = new PriorityQueue<>(new Comparator<Jaehwan>() {
            @Override
            public int compare(Jaehwan o1, Jaehwan o2) {
                return o1.count - o2.count;
            }
        });

        jaehwanPriorityQueue.add(new Jaehwan(0, 0));
        visit[0] = true;

        while(!jaehwanPriorityQueue.isEmpty()) {
            Jaehwan now = jaehwanPriorityQueue.remove();
            if(now.position == n - 1) {
                ans = now.count;
                return;
            }

            int nowDist = board[now.position];

            for(int dist = nowDist; dist > 0; dist--) {
                int afterPosition = now.position + dist;
                if(afterPosition >= n || visit[afterPosition]) continue;

                visit[afterPosition] = true;
                jaehwanPriorityQueue.add(new Jaehwan(now.position + dist, now.count + 1));
            }
        }
    }

    static class Jaehwan {
        int position;
        int count;

        public Jaehwan(int position, int count) {
            this.position = position;
            this.count = count;
        }
    }
}