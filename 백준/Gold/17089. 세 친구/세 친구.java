import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m, ans;
    static Set<Integer>[] friends;

    public static void main(String[] args) {
        input();
        findFriends();
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        friends = new Set[n + 1];

        for(int idx = 1; idx <= n; idx++) {
            friends[idx] = new HashSet<>();
        }

        for(int idx = 0; idx < m; idx++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            friends[a].add(b);
            friends[b].add(a);
        }

        ans = Integer.MAX_VALUE;
    }

    static void findFriends() {
        for(int a = 1; a <= n; a++) {
            if(friends[a].size() < 2) continue;

            for (int b : friends[a]) {
                if(friends[b].size() < 2) continue;

                for(int c : friends[b]) {
                    if(c == a || friends[c].size() < 2) continue;

                    if(friends[c].contains(a)) {
                        int sum = friends[a].size() + friends[b].size() + friends[c].size() - 6;

                        ans = Math.min(ans, sum);
                    }
                }
            }
        }
    }
}