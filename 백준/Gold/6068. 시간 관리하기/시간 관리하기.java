import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static PriorityQueue<Work> works;
    static int n, ans;

    public static void main(String[] args) {
        input();
        work();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        works = new PriorityQueue<>(new Comparator<Work>() {
            @Override
            public int compare(Work o1, Work o2) {
                return o2.s - o1.s;
            }
        });

        while(n-- > 0) {
            works.add(new Work(sc.nextInt(), sc.nextInt()));
        }
        
        ans = -1;
    }

    static void work() {
        int nowTime = 1_000_001;

        while(!works.isEmpty()) {
            Work now = works.remove();

            if(nowTime > now.s) {
                nowTime = now.s;
            }

            nowTime -= now.t;

            if(nowTime < 0) return;
        }

        ans = nowTime;
    }
}

class Work {
    int t;
    int s;

    public Work(int t, int s) {
        this.t = t;
        this.s = s;
    }
}