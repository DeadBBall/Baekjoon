import java.util.*;

public class Main {
    static final int[] DY = {1, -1 ,0, 0};
    static final int[] DX = {0, 0, 1, -1};
    static Scanner sc = new Scanner(System.in);
    static int m, n;
    static boolean[][] board;

    public static void main(String[] args) {
        input();
        System.out.println(percolate() ? "YES" : "NO");
    }

    static void input() {
        m = sc.nextInt();
        n = sc.nextInt();
        board = new boolean[m][n];

        for(int y = 0; y < m; y++) {
            String inputBoard = sc.next();

            for(int x = 0; x < n; x++) {
                board[y][x] = inputBoard.charAt(x) == '1';
            }
        }
    }

    static boolean percolate() {
        for(int x = 0; x < n; x++) {
            if(!board[0][x]) {
                if(bfs(x)) return true;
            }
        }

        return false;
    }

    static boolean bfs(int xStart) {
        Queue<Position> positions = new LinkedList<>();
        positions.add(new Position(0, xStart));
        board[0][xStart] = true;

        while(!positions.isEmpty()) {
            Position now = positions.remove();

            for(int drct = 0; drct < 4; drct++) {
                int ny = now.y + DY[drct];
                int nx = now.x + DX[drct];

                if(!canMove(ny, nx)) continue;

                if(ny == m - 1) return true;

                board[ny][nx] = true;

                positions.add(new Position(ny, nx));
            }

        }

        return false;
    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < m && x >= 0 && x < n && !board[y][x];
    }
}

class Position {
    int y;
    int x;

    public Position(int y, int x) {
        this.y = y;
        this.x = x;
    }
}