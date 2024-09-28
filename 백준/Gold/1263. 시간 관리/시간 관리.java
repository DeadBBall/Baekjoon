import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static Work[] works;

    public static void main(String[] args) {
        input();
        plan();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        works = new Work[n];

        for(int idx = 0; idx < n; idx++) {
            int t = sc.nextInt();
            int s = sc.nextInt();

            works[idx] = new Work(s, t);
        }

        Arrays.sort(works, new Comparator<Work>() {
            @Override
            public int compare(Work o1, Work o2) {
                if(o1.limit == o2.limit) return o2.time - o1.time;

                return o2.limit - o1.limit;
            }
        });

        ans = -1;
    }

    static void plan() {
        int time = works[0].limit;

        for(int idx = 0; idx < n; idx++) {
            if(time > works[idx].limit) {
                time = works[idx].limit;
            }

            if(time - works[idx].time < 0) return;

            time -= works[idx].time;
        }

        ans = time;
    }
}

class Work {
    int limit;
    int time;

    public Work(int limit, int time) {
        this.limit = limit;
        this.time = time;
    }
}