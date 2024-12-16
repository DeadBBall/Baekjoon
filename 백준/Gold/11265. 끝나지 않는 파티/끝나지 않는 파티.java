import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static int[][] edges;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        findRoute();
        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        edges = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                edges[i][j] = sc.nextInt();
            }
        }

        ansMaker = new StringBuilder();
    }

    static void findRoute() {
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    edges[i][j] = Math.min(edges[i][j], edges[i][k] + edges[k][j]);
                }
            }
        }

        while(m-- > 0) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int c = sc.nextInt();

            if(edges[a][b] <= c) {
                ansMaker.append("Enjoy other party").append("\n");
            } else {
                ansMaker.append("Stay here").append("\n");
            }
        }
    }

}