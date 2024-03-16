import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m, k;
    static int[][] board;

    public static void main(String[] args) {
        input();
        moveRobot();
        System.out.println(board[n][m]);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        board = new int[n + 1][m + 1];
    }

    static void moveRobot() {
        for(int y = 1; y <= n; y++) {
            board[y][1] = 1;
        }

        for(int x = 1; x <= m; x++) {
            board[1][x] = 1;
        }

        if(k == 0) {
            for(int y = 2; y <= n; y++) {
                for(int x = 2; x <= m; x++) {
                    board[y][x] = board[y - 1][x] + board[y][x - 1];
                }
            }
        }

        else {
            int targetY = k / m + 1;
            int targetX = k % m;

            for(int y = 2; y <= targetY; y++) {
                for(int x = 2; x <= targetX; x++) {
                    board[y][x] = board[y - 1][x] + board[y][x - 1];
                }
            }

            for(int y = targetY + 1; y <= n; y++) {
                board[y][targetX] = board[targetY][targetX];
            }

            for(int x = targetX + 1; x <= m; x++) {
                board[targetY][x] = board[targetY][targetX];
            }

            for(int y = targetY + 1; y <= n; y++) {
                for(int x = targetX + 1; x <= m; x++) {
                    board[y][x] = board[y - 1][x] + board[y][x - 1];
                }
            }
        }
    }

}