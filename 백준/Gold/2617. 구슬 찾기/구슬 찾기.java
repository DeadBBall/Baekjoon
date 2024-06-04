import java.util.Scanner;

public class Main {
    static final int INF = 987654321;
    static Scanner sc = new Scanner(System.in);
    static int n, m, ans;
    static int[][] edges;

    public static void main(String[] args) {
        input();
        checkBead();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        edges = new int[n + 1][n + 1];

        for(int start = 1; start <= n; start++) {
            for(int end = 1; end <= n; end++) {
                edges[start][end] = INF;
            }
        }

        while(m-- > 0) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            edges[start][end] = 1;
        }
    }

    static void checkBead() {
        for(int mid = 1; mid <= n; mid++) {
            for(int start = 1; start <= n; start++) {
                for(int end = 1; end <= n; end++) {
                    edges[start][end] = Math.min(edges[start][mid] + edges[mid][end], edges[start][end]);
                }
            }
        }

        for(int idx = 1; idx <= n; idx++) {
            ans += compareWeight(idx);
        }

    }

    static int compareWeight(int num) {
        int sum = 0;

        for(int end = 1; end <= n; end++) {
            if(edges[num][end] != INF) sum++;
        }

        if(sum > n / 2) return 1;

        sum = 0;

        for(int start = 1; start <= n; start++) {
            if(edges[start][num] != INF) sum++;
        }

        return sum > n / 2 ? 1 : 0;
    }

}