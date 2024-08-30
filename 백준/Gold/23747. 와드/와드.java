import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int[] DY = {1, -1, 0, 0};
    static final int[] DX = {0 ,0, 1, -1};
    static Scanner sc = new Scanner(System.in);
    static int r, c, hbX, hbY;
    static String records;
    static String[] board;
    static char[][] answers;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        move();
        System.out.print(ansMaker);
    }

    static void input() {
        r = sc.nextInt();
        c = sc.nextInt();
        answers = new char[r][c];
        for(int y = 0; y < r; y++) {
            Arrays.fill(answers[y], '#');
        }

        board = new String[r];

        for(int y = 0; y < r; y++) {
            String line = sc.next();

            board[y] = line;
        }

        hbY = sc.nextInt() - 1;
        hbX = sc.nextInt() - 1;

        records = sc.next();

        ansMaker = new StringBuilder();
    }

    static void move() {
        for(int idx = 0; idx < records.length(); idx++) {
            char now = records.charAt(idx);

            if(now == 'U') {
                hbY--;
            } else if(now == 'D') {
                hbY++;
            } else if(now == 'L') {
                hbX--;
            } else if(now == 'R') {
                hbX++;
            } else {
                dfs(hbY, hbX);
            }
        }

        answers[hbY][hbX] = '.';

        for(int drct = 0; drct < 4; drct++) {
            int ny = hbY + DY[drct];
            int nx = hbX + DX[drct];

            if(!canMove(ny, nx)) continue;

            answers[ny][nx] = '.';
        }

        for(int y = 0; y < r; y++) {
            ansMaker.append(answers[y]).append("\n");
        }
    }

    static void dfs(int y, int x) {
        answers[y][x] = '.';

        for(int drct = 0; drct < 4; drct++) {
            int ny = y + DY[drct];
            int nx = x + DX[drct];

            if(!canMove(ny, nx) || board[y].charAt(x) != board[ny].charAt(nx)
                    || answers[ny][nx] == '.') continue;

            dfs(ny, nx);
        }
    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < r && x >= 0 && x < c;
    }
}