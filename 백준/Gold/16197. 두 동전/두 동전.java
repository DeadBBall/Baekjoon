import java.util.*;

public class Main {
    static final char COIN = 'o';
    static final char EMPTY = '.';
    static final char WALL = '#';
    static final int[] DY = {1, -1, 0, 0};
    static final int[] DX = {0, 0, 1, -1};
    static Scanner sc = new Scanner(System.in);
    static int n, m, ans;
    static List<int[]> coins;
    static char[][] board;

    public static void main(String[] args) {
        input();
        playGame();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        board = new char[n][m];
        coins = new ArrayList<>();
        ans = -1;

        for(int y = 0; y < n; y++) {
            String boardInput = sc.next();

            for(int x = 0; x < m; x++) {
                board[y][x] = boardInput.charAt(x);

                if(board[y][x] == COIN) {
                    coins.add(new int[]{y, x});
                    board[y][x] = EMPTY;
                }
            }
        }
    }

    static void playGame() {
        Queue<Turn> turnQueue = new LinkedList<>();

        turnQueue.add(new Turn(coins.get(0)[0], coins.get(0)[1], coins.get(1)[0], coins.get(1)[1], 0));

        while(!turnQueue.isEmpty()) {
            Turn now = turnQueue.remove();

            if(now.moveCount == 10) return;

            for(int drct = 0; drct < 4; drct++) {
                int ny1 = now.y1 + DY[drct];
                int nx1 = now.x1 + DX[drct];
                int ny2 = now.y2 + DY[drct];
                int nx2 = now.x2 + DX[drct];

                if((isOut(ny1, nx1) && !isOut(ny2, nx2)) || (!isOut(ny1, nx1) && isOut(ny2, nx2))) {
                    ans = now.moveCount + 1;
                    return;
                }

                else if(isOut(ny1, nx1) && isOut(ny2, nx2)) continue;

                if(board[ny1][nx1] == WALL && board[ny2][nx2] == WALL) continue;

                if(board[ny1][nx1] == WALL) {
                    ny1 = now.y1;
                    nx1 = now.x1;
                }

                if(board[ny2][nx2] == WALL) {
                    ny2 = now.y2;
                    nx2 = now.x2;
                }

                if(ny1 == ny2 && nx1 == nx2) {
                    if(ny1 == now.y1 && nx1 == now.x1) {
                        ny2 = now.y2;
                        nx2 = now.x2;
                    }
                    else {
                        ny1 = now.y1;
                        nx1 = now.x1;
                    }
                }

                turnQueue.add(new Turn(ny1, nx1, ny2, nx2, now.moveCount + 1));
            }
        }
    }

    static boolean isOut(int y, int x) {
        return y < 0 || y >= n || x < 0 || x >= m;
    }

}

class Turn {
    int y1;
    int x1;
    int y2;
    int x2;
    int moveCount;

    public Turn(int y1, int x1, int y2, int x2, int moveCount) {
        this.y1 = y1;
        this.x1 = x1;
        this.y2 = y2;
        this.x2 = x2;
        this.moveCount = moveCount;
    }
}