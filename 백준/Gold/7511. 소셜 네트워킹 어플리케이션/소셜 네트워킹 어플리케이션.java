import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, k, m;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= t; tc++) {
            ansMaker.append("Scenario ").append(tc).append(":\n");
            input();
            findFriends();
        }

        System.out.print(ansMaker);
    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        parents = new int[n + 1];
        for(int idx = 1; idx <= n; idx++) {
            parents[idx] = idx;
        }

        while(k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        m = Integer.parseInt(br.readLine());
    }

    static int find(int x) {
        if(x == parents[x]) return x;

        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) return;
        else if(x > y) {
            parents[x] = y;
        } else {
            parents[y] = x;
        }
    }

    static void findFriends() throws IOException {
        while(m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if(find(u) == find(v)) {
                ansMaker.append(1).append("\n");
            } else {
                ansMaker.append(0).append("\n");
            }
        }

        ansMaker.append("\n");
    }
}