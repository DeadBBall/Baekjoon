import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, a, b, m, ans;
    static List<Integer>[] family;
    static boolean[] visit;
    static void input() {
        n = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        m = sc.nextInt();
        family = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        for(int i = 1; i <= n; i++) {
            family[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            int x, y;
            x = sc.nextInt();
            y = sc.nextInt();
            family[x].add(y);
            family[y].add(x);
        }
    }

    static void checkFamily() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {a, 0});
        while(!q.isEmpty()) {
            int[] now = q.remove();
            if(now[0] == b) {
                ans = now[1];
                return;
            }
            for(int i = 0; i < family[now[0]].size(); i++) {
                int num = family[now[0]].get(i);
                if(visit[num]) {
                    continue;
                }
                visit[num] = true;
                q.add(new int[]{num, now[1] + 1});
            }
        }
    }

    public static void main(String[] args) {
        input();
        checkFamily();
        System.out.println(ans == 0 ? -1 : ans);
    }
}