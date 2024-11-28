import java.util.*;

public class Main {
    static final char SAFE = '1';
    static final char UNSAFE = '0';
    static Scanner sc = new Scanner(System.in);
    static int n, k;
    static String[] board;

    public static void main(String[] args) {
        input();
        System.out.println(playGame() ? 1 : 0);
    }

    static void input() {
        n = sc.nextInt();
        k = sc.nextInt();
        board = new String[2];

        for(int idx = 0; idx < 2; idx++) {
            board[idx] = sc.next();
        }
    }

    static boolean playGame() {
        boolean[][] visit = new boolean[n][2];
        visit[0][0] = true;

        Queue<Pos> posQueue = new LinkedList<>();
        posQueue.add(new Pos(0, 0, 0));

        while(!posQueue.isEmpty()) {
            Pos now = posQueue.remove();

            if(now.idx >= n - 1) return true;

            if(!visit[now.idx + 1][now.line] && board[now.line].charAt(now.idx + 1) == SAFE) {
                visit[now.idx + 1][now.line] = true;
                posQueue.add(new Pos(now.idx + 1, now.line, now.time + 1));
            }

            if(now.idx > 0 && !visit[now.idx - 1][now.line] && board[now.line].charAt(now.idx - 1) == SAFE
                && now.time < now.idx - 1) {
                visit[now.idx - 1][now.line] = true;
                posQueue.add(new Pos(now.idx - 1, now.line, now.time + 1));
            }

            if(now.idx + k >= n) return true;
            else {
                int nextLine = now.line == SAFE - '0' ? UNSAFE - '0' : SAFE - '0';

                if(!visit[now.idx + k][nextLine] && board[nextLine].charAt(now.idx + k) == SAFE) {
                    visit[now.idx + k][nextLine] = true;
                    posQueue.add(new Pos(now.idx + k, nextLine, now.time + 1));
                }
            }
        }

        return false;
    }

}

class Pos {
    int idx;
    int line;
    int time;

    public Pos(int idx, int line, int time) {
        this.idx = idx;
        this.line = line;
        this.time = time;
    }
}