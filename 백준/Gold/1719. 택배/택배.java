import java.util.Scanner;

public class Main {
    static final int INF = 987654321;
    static Scanner sc = new Scanner(System.in);
    static int[][] edges;
    static int[][] answers;
    static int n, m;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        moveCargo();
        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();

        edges = new int[n + 1][n + 1];
        answers = new int[n + 1][n + 1];

        for(int a = 1; a <= n; a++) {
            for(int b = 1; b <= n; b++) {
                if(a == b) continue;

                edges[a][b] = INF;
            }
        }

        while(m-- > 0) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int dist = sc.nextInt();

            edges[start][end] = dist;
            edges[end][start] = dist;

            answers[start][end] = end;
            answers[end][start] = start;
        }

        ansMaker = new StringBuilder();
    }

    static void moveCargo() {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k++) {
                    if(edges[j][k] > edges[j][i] + edges[i][k]) {
                        edges[j][k] = edges[j][i] + edges[i][k];
                        answers[j][k] = answers[j][i];
                    }
                }
            }
        }

        for(int start = 1; start <= n; start++) {
            for(int end = 1; end <= n; end++) {
                if(answers[start][end] == 0) {
                    ansMaker.append("- ");
                }
                else {
                    ansMaker.append(answers[start][end]).append(" ");
                }
            }
            ansMaker.append("\n");
        }
    }

}