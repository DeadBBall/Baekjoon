import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static final int ROAD = 1;
    static final int TARGET = 2;
    static final int[] dy = {1, -1, 0, 0};
    static final int[] dx = {0, 0, 1, -1};
    static int n;
    static int m;
    static int startX;
    static int startY;
    static int[][] board;
    static boolean[][] visit;

    public static void main(String[] args) {
        input();
        calculateDistanceToTarget();
        printBoard();
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];
        visit = new boolean[n][m];

        for(int y = 0; y < n; y++) {
            for(int x = 0; x < m; x++) {
                board[y][x] = sc.nextInt();

                if(board[y][x] == TARGET) {
                    startY = y;
                    startX = x;
                    board[y][x] = 0;
                }
            }
        }
    }

    static void calculateDistanceToTarget() {
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(new Node(startY, startX, 0));

        while(!nodeQueue.isEmpty()) {
            Node nowNode = nodeQueue.remove();

            for(int drct = 0; drct < 4; drct++) {
                int ny = nowNode.y + dy[drct];
                int nx = nowNode.x + dx[drct];

                if(!canMove(ny, nx)) continue;

                visit[ny][nx] = true;
                board[ny][nx] = nowNode.dist + 1;
                nodeQueue.add(new Node(ny, nx, nowNode.dist + 1));
            }
        }
    }

    static boolean canMove(int y, int x) {
        if(y < 0 || x < 0 || y >= n || x >= m) return false;
        if(board[y][x] != ROAD || visit[y][x]) return false;
        return true;
    }

    static void printBoard() {
        StringBuilder ansMaker = new StringBuilder();
        for(int y = 0; y < n; y++) {
            for(int x = 0; x < m; x++) {
                if(!visit[y][x] && board[y][x] == ROAD) {
                    ansMaker.append(-1).append(" ");
                } else {
                    ansMaker.append(board[y][x]).append(" ");
                }
            }
            ansMaker.append("\n");
        }
        System.out.print(ansMaker);
    }

    static class Node {
        int y;
        int x;
        int dist;

        public Node(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }

}