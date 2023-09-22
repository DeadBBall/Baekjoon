import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static final int[] DY = {1, 0, -1, 0};
    static final int[] DX = {0, 1, 0, -1};
    static int n;
    static int target;
    static Position targetPosition;
    static int[][] board;
    static Position start;


    public static void main(String[] args) {
        input();
        move();
        printAns();
    }

    static void input() {
        n = sc.nextInt();
        target = sc.nextInt();
        board = new int[n + 1][n + 1];
        start = new Position(1, 1);
    }

    static void move() {
        Position now = start;
        int nowNumber = n * n;
        int nowDrct = 0;
        while(true) {
            if(nowNumber == target) {
                targetPosition = new Position(now.y, now.x);
            }
            board[now.y][now.x] = nowNumber--;
            if(nowNumber == 0) return;
            int ny = now.y + DY[nowDrct];
            int nx = now.x + DX[nowDrct];
            if(!canMove(ny, nx)) {
                nowDrct = (nowDrct + 1) % 4;
            }
            now.y += DY[nowDrct];
            now.x += DX[nowDrct];
        }
    }

    static boolean canMove(int y, int x) {
        return y > 0 && x > 0 && y <= n && x <= n && board[y][x] == 0;
    }

    static void printAns() {
        StringBuilder ansMaker = new StringBuilder();
        for(int y = 1; y <= n; y++) {
            for(int x = 1; x <= n; x++) {
                ansMaker.append(board[y][x] + " ");
            }
            ansMaker.append("\n");
        }
        ansMaker.append(targetPosition.y + " " + targetPosition.x);
        System.out.println(ansMaker);
    }

    static class Position {
        int y;
        int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}