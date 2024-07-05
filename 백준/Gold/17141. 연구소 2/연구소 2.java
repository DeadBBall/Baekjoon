import java.util.*;

public class Main {
    static final int EMPTY = 0;
    static final int WALL = 1;
    static final int VIRUS = 2;
    static final int INF = Integer.MAX_VALUE;
    static final int[] DY = {1, -1, 0, 0};
    static final int[] DX = {0, 0, 1, -1};
    static Scanner sc = new Scanner(System.in);
    static int n, m, ans;
    static int[][] board;
    static List<Virus> virus;

    public static void main(String[] args) {
        input();
        selectSpace(new ArrayList<>(), 0);
        System.out.println(ans == INF ? -1 : ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][n];

        virus = new ArrayList<>();

        for(int y = 0; y < n; y++) {
            for(int x = 0; x < n; x++) {
                board[y][x] = sc.nextInt();

                if(board[y][x] == VIRUS) {
                    virus.add(new Virus(y, x));
                }
            }
        }

        ans = INF;
    }

    static void selectSpace(List<Virus> virusList, int now) {
        if(virusList.size() == m) {
            int result = bfs(virusList);
            ans = Math.min(ans, result);
            return;
        }

        for(int idx = now; idx < virus.size(); idx++) {
            virusList.add(virus.get(idx));

            selectSpace(virusList, idx + 1);

            virusList.remove(virusList.size() - 1);
        }
    }

    static int bfs(List<Virus> virusList) {
        boolean[][] visit = new boolean[n][n];
        virusList.forEach(v -> visit[v.y][v.x] = true);

        Queue<Virus> virusQueue = new LinkedList<>(virusList);

        int time = 0;

        while(!virusQueue.isEmpty()) {
            if(isFinisihed(visit)) return time;

            time++;

            int queueSize = virusQueue.size();

            for(int idx = 0; idx < queueSize; idx++) {
                Virus now = virusQueue.remove();

                for(int drct = 0; drct < 4; drct++) {
                    int ny = now.y + DY[drct];
                    int nx = now.x + DX[drct];

                    if(!canMove(ny, nx) || visit[ny][nx] || board[ny][nx] == WALL) continue;

                    visit[ny][nx] = true;

                    virusQueue.add(new Virus(ny, nx));
                }
            }

        }

        return INF;
    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    static boolean isFinisihed(boolean[][] visit) {
        for(int y = 0; y < n; y++) {
            for(int x = 0; x < n; x++) {
                if(!visit[y][x] && board[y][x] != WALL) return false;
            }
        }

        return true;
    }
}

class Virus {
    int y;
    int x;

    Virus(int y, int x) {
        this.y = y;
        this.x = x;
    }
}