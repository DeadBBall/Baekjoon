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
                int na = now.a > now.b ? now.a - now.b : 2 * now.a;
                int nb = now.a > now.b ? 2 * now.b : now.b - now.a;
                
                if(na == nb && nb == now.c) return 1;

                if(!visit[na][nb]) {
                    visit[na][nb] = visit[nb][na] = true;
                    turns.add(new Turn(na, nb, now.c));
                }
            }
            if(now.b != now.c) {
                int nb = now.b > now.c ? now.b - now.c : 2 * now.b;
                int nc = now.b > now.c ? 2 * now.c : now.c - now.b;
                
                if(now.a == nb && nb == nc) return 1;

                if(!visit[nb][nc]) {
                    visit[nb][nc] = visit[nc][nb] = true;
                    turns.add(new Turn(now.a, nb, nc));
                }
            }
            if(now.a != now.c) {
                int na = now.a > now.c ? now.a - now.c : 2 * now.a;
                int nc = now.a > now.c ? 2 * now.c : now.c - now.a;
                
                if(na == now.b && now.b == nc) return 1;

                if(!visit[na][nc]) {
                    visit[na][nc] = visit[nc][na] = true;
                    turns.add(new Turn(na, now.b, nc));
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