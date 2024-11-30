import java.util.*;

public class Main {
    static final int EMPTY = 0;
    static final int MINE = 1;
    static final int ENEMY = 2;
    static final int[] DY = {1, -1, 0, 0};
    static final int[] DX = {0, 0, 1, -1};
    static Scanner sc = new Scanner(System.in);
    static int n, m, ans;
    static int[][] board;
    static List<Stone> stones;

    public static void main(String[] args) {
        input();
        playGo();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];
        stones = new ArrayList<>();

        for(int y = 0; y < n; y++) {
            for(int x = 0; x < m; x++) {
                board[y][x] = sc.nextInt();

                if(board[y][x] == EMPTY) {
                    stones.add(new Stone(y, x));
                }
            }
        }
    }

    static void playGo() {
        for(int i = 0; i < stones.size() - 1; i++) {
            for(int j = i + 1; j < stones.size(); j++) {
                board[stones.get(i).y][stones.get(i).x] = MINE;
                board[stones.get(j).y][stones.get(j).x] = MINE;

                ans = Math.max(ans, countStones());

                board[stones.get(i).y][stones.get(i).x] = EMPTY;
                board[stones.get(j).y][stones.get(j).x] = EMPTY;
            }
        }
    }

    static int countStones() {
        boolean[][] visit = new boolean[n][m];

        int cnt = 0;

        for(int y = 0; y < n; y++) {
            for(int x = 0; x < m; x++) {
                if(!visit[y][x] && board[y][x] == ENEMY) {
                    cnt += bfs(y, x, visit);
                }
            }
        }

        return cnt;
    }

    static int bfs(int y, int x, boolean[][] visit) {
        Queue<Stone> stoneQueue = new LinkedList<>();
        stoneQueue.add(new Stone(y, x));

        visit[y][x] = true;

        int cnt = 1;
        boolean flag = false;

        while(!stoneQueue.isEmpty()) {
            Stone now = stoneQueue.remove();

            for(int drct = 0; drct < 4; drct++) {
                int ny = now.y + DY[drct];
                int nx = now.x + DX[drct];

                if(!canMove(ny, nx) || board[ny][nx] == MINE || visit[ny][nx]) continue;

                if(board[ny][nx] == EMPTY) flag = true;

                if(!visit[ny][nx] && board[ny][nx] == ENEMY) cnt++;

                visit[ny][nx] = true;

                stoneQueue.add(new Stone(ny, nx));
            }
        }

        return flag ? 0 : cnt;
    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }

}

class Stone {
    int y;
    int x;

    public Stone(int y, int x) {
        this.y = y;
        this.x = x;
    }
}