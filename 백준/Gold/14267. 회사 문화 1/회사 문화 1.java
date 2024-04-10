import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker;
    static List<Integer>[] subordinates;
    static int n, m;
    static int[] dp;

    public static void main(String[] args) {
        input();
        praiseSubordinates(1);
        for(int staff = 1; staff <= n; staff++) {
           ansMaker.append(dp[staff]).append(" ");
        }
        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        dp = new int[n + 1];
        subordinates = new List[n + 1];

        for(int staffIdx = 1; staffIdx <= n; staffIdx++) {
            subordinates[staffIdx] = new ArrayList<>();
        }

        for(int staffIdx = 1; staffIdx <= n; staffIdx++) {
            int boss = sc.nextInt();

            if(boss == -1) continue;

            subordinates[boss].add(staffIdx);
        }

        for(int praiseIdx = 0; praiseIdx < m; praiseIdx++) {
            int staff = sc.nextInt();
            int power = sc.nextInt();

            dp[staff] += power;
        }

        ansMaker = new StringBuilder();
    }

    static void praiseSubordinates(int now) {
        for(int subordinate : subordinates[now]) {
            dp[subordinate] += dp[now];
            praiseSubordinates(subordinate);
        }
    }

}