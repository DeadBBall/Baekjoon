import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static boolean[][] visit;
    static int a, b, c;

    public static void main(String[] args) {
        input();
        System.out.println(playGame());
    }

    static void input() {
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        visit = new boolean[a + b + c + 1][a + b + c + 1];
    }

    static int playGame() {
        if((a + b + c) % 3 != 0) return 0;

        if(a == b && b == c) return 1;
        
        Queue<Turn> turns = new LinkedList<>();
        turns.add(new Turn(a, b, c));
        visit[a][b] = visit[b][a] = visit[a][c] = visit[c][a] = visit[b][c] = visit[c][b] = true;

        while(!turns.isEmpty()) {
            Turn now = turns.remove();

            if(now.a != now.b) {
                int na = 0;
                int nb = 0;
                int nc = now.c;
                if(now.a > now.b) {
                    na = now.a - now.b;
                    nb = 2 * now.b;
                }
                else {
                    na = 2 * now.a;
                    nb = now.b - now.a;
                }
                if(na == nb && nb == nc) return 1;

                if(!visit[na][nb] && !visit[nb][na]) {
                    visit[na][nb] = visit[nb][na] = true;
                    turns.add(new Turn(na, nb, nc));
                }
            }
            if(now.b != now.c) {
                int na = now.a;
                int nb = 0;
                int nc = 0;
                if(now.b > now.c) {
                    nb = now.b - now.c;
                    nc = 2 * now.c;
                }
                else {
                    nb = 2 * now.b;
                    nc = now.c - now.b;
                }
                if(na == nb && nb == nc) return 1;

                if(!visit[nb][nc] && !visit[nc][nb]) {
                    visit[nb][nc] = visit[nc][nb] = true;
                    turns.add(new Turn(na, nb, nc));
                }
            }
            if(now.a != now.c) {
                int na = 0;
                int nb = now.b;
                int nc = 0;
                if(now.a > now.c) {
                    na = now.a - now.c;
                    nc = 2 * now.c;
                }
                else {
                    na = 2 * now.a;
                    nc = now.c - now.a;
                }
                if(na == nb && nb == nc) return 1;

                if(!visit[na][nc] && !visit[nc][na]) {
                    visit[na][nc] = visit[nc][na] = true;
                    turns.add(new Turn(na, nb, nc));
                }
            }
        }
        return 0;
    }

}

class Turn {
    int a;
    int b;
    int c;

    public Turn(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}