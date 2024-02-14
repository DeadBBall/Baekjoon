import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int a, b, n, m, ans;
    static boolean[] visit = new boolean[100001];

    public static void main(String[] args) {
        input();
        goToJumi();
        System.out.println(ans);
    }

    static void input() {
        a = sc.nextInt();
        b = sc.nextInt();
        n = sc.nextInt();
        m = sc.nextInt();

        visit[n] = true;
    }

    static void goToJumi() {
        PriorityQueue<Donggyu> donggyuQueue = new PriorityQueue<>(new Comparator<Donggyu>() {
            @Override
            public int compare(Donggyu o1, Donggyu o2) {
                return o1.count - o2.count;
            }
        });
        donggyuQueue.add(new Donggyu(n, 0));

        while(!donggyuQueue.isEmpty()) {
            Donggyu now = donggyuQueue.remove();

            if(now.pos == m) {
                ans = now.count;
                return;
            }

            if(now.pos * a <= 100000 && !visit[now.pos * a]) {
                visit[now.pos * a] = true;
                donggyuQueue.add(new Donggyu(now.pos * a, now.count + 1));
            }

            if(now.pos * b <= 100000 && !visit[now.pos * b]) {
                visit[now.pos * b] = true;
                donggyuQueue.add(new Donggyu(now.pos * b, now.count + 1));
            }

            if(now.pos + a <= 100000 && !visit[now.pos + a]) {
                visit[now.pos + a] = true;
                donggyuQueue.add(new Donggyu(now.pos + a, now.count + 1));
            }

            if(now.pos + b <= 100000 && !visit[now.pos + b]) {
                visit[now.pos + b] = true;
                donggyuQueue.add(new Donggyu(now.pos + b, now.count + 1));
            }

            if(now.pos - a >= 0 && !visit[now.pos - a]) {
                visit[now.pos - a] = true;
                donggyuQueue.add(new Donggyu(now.pos - a, now.count + 1));
            }

            if(now.pos - b >= 0 && !visit[now.pos - b]) {
                visit[now.pos - b] = true;
                donggyuQueue.add(new Donggyu(now.pos - b, now.count + 1));
            }

            if(now.pos + 1 <= 100000 && !visit[now.pos + 1]) {
                visit[now.pos + 1] = true;
                donggyuQueue.add(new Donggyu(now.pos + 1, now.count + 1));
            }

            if(now.pos - 1 >= 0 && !visit[now.pos - 1]) {
                visit[now.pos - 1] = true;
                donggyuQueue.add(new Donggyu(now.pos - 1, now.count + 1));
            }
        }
    }

}

class Donggyu {
    int pos;
    int count;

    public Donggyu(int pos, int count) {
        this.pos = pos;
        this.count = count;
    }
}