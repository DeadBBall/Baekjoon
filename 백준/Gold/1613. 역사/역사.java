import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker;
    static int n, k;
    static int[][] edges;

    public static void main(String[] args) {
        input();
        inferOrder();
        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        k = sc.nextInt();
        edges = new int[n + 1][n + 1];

        for(int edgeIdx = 0; edgeIdx < k; edgeIdx++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            edges[start][end] = 1;
        }

        ansMaker = new StringBuilder();
    }

    static void inferOrder() {
        floydWarshall();

        int s = sc.nextInt();

        while(s-- > 0) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            if(edges[start][end] != 0) {
                ansMaker.append(-1);
            }
            else if(edges[end][start] != 0) {
                ansMaker.append(1);
            }
            else {
                ansMaker.append(0);
            }
            ansMaker.append("\n");
        }

    }

    static void floydWarshall() {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k++) {
                    if(edges[j][k] == 0 && edges[j][i] != 0 && edges[i][k] != 0) {
                        edges[j][k] = edges[j][i] + edges[i][k];
                    }
                }
            }
        }
    }
}