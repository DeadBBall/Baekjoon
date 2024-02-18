import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m, ans;
    static int[] parents;

    public static void main(String[] args) {
        input();
        playGame();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        parents = new int[n];

        for(int nodeIdx = 0; nodeIdx < n; nodeIdx++) {
            parents[nodeIdx] = nodeIdx;
        }
    }

    static void playGame() {
        for(int edgeIdx = 1; edgeIdx <= m; edgeIdx++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            start = find(start);
            end = find(end);

            if(start == end) {
                ans = edgeIdx;
                break;
            }

            union(start, end);
        }
    }

    static int find(int x) {
        if(x == parents[x]) return x;

        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) return;

        parents[y] = x;
    }

}