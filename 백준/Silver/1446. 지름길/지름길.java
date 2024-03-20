import java.util.*;

public class Main {
    static final int INF = 123456;
    static Scanner sc = new Scanner(System.in);
    static int n, d;
    static int[] dp;
    static List<Shortcut> shortcuts;

    public static void main(String[] args) {
        input();
        drive();
        System.out.println(dp[d]);
    }

    static void input() {
        n = sc.nextInt();
        d = sc.nextInt();

        dp = new int[d + 1];

        Arrays.fill(dp, INF);

        shortcuts = new ArrayList<>();

        for(int shortcutIdx = 0; shortcutIdx < n; shortcutIdx++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int dist = sc.nextInt();

            if(end > d) continue;

            if(dist > end - start) continue;

            shortcuts.add(new Shortcut(start, end, dist));
        }

        Collections.sort(shortcuts, new Comparator<Shortcut>(){
            @Override
            public int compare(Shortcut a, Shortcut b) {
                return a.start - b.start;
            }
        });
    }

    static void drive() {
        int shortcutIdx = 0;

        dp[0] = 0;

        for(int position = 0; position <= d; position++) {
            if(position != 0) {
                dp[position] = Math.min(dp[position], dp[position - 1] + 1);
            }

            if(shortcutIdx < shortcuts.size() && shortcuts.get(shortcutIdx).start == position) {
                while(shortcutIdx < shortcuts.size() && shortcuts.get(shortcutIdx).start == position) {
                    Shortcut now = shortcuts.get(shortcutIdx);

                    dp[now.end] = Math.min(dp[now.end], dp[now.start] + now.dist);

                    shortcutIdx++;
                }
            }
        }
    }
}

class Shortcut {
    int start;
    int end;
    int dist;

    public Shortcut(int start, int end, int dist) {
        this.start = start;
        this.end = end;
        this.dist = dist;
    }
}