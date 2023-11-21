import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;

    public static void main(String[] args) {
        input();
        makeEmoticon();
        System.out.println(ans);
    }
    static void input() {
        n = sc.nextInt();
    }

    static void makeEmoticon() {
        boolean[][] visit = new boolean[n + 1][n + 1];

        PriorityQueue<Emoticon> emoticons = new PriorityQueue<>(new Comparator<Emoticon>() {
            @Override
            public int compare(Emoticon o1, Emoticon o2) {
                return o1.time - o2.time;
            }
        });

        emoticons.add(new Emoticon(0, 0, 1));
        while(!emoticons.isEmpty()) {
            Emoticon now = emoticons.remove();
            if(visit[now.total][now.clipBoard]) continue;
            visit[now.total][now.clipBoard] = true;
            if(now.total == n) {
                ans = now.time;
                return;
            }
            if(now.clipBoard != 0 && now.total + now.clipBoard <= n)
                emoticons.add(new Emoticon(now.clipBoard, now.time + 1, now.total + now.clipBoard));

            emoticons.add(new Emoticon(now.total, now.time + 1, now.total));

            if(now.total > 1)
                emoticons.add(new Emoticon(now.clipBoard, now.time + 1, now.total - 1));
        }
    }

    static class Emoticon {
        int clipBoard;
        int time;
        int total;

        public Emoticon(int clipBoard, int time, int total) {
            this.clipBoard = clipBoard;
            this.time = time;
            this.total = total;
        }
    }
}