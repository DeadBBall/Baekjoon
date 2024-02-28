import java.util.*;

public class Main {
    static final int[] DY = {0, 0, 1, -1};
    static final int[] DX = {1, -1, 0, 0};
    static final int START = 14;
    static Scanner sc = new Scanner(System.in);
    static double ans;
    static boolean[][] visit;
    static int[] probabilities;
    static int n;

    public static void main(String[] args) {
        input();
        moveRobot(0, 1, new Position(START, START));
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        visit = new boolean[29][29];
        visit[START][START] = true;

        probabilities = new int[4];
        for(int drct = 0; drct < 4; drct++) {
            probabilities[drct] = sc.nextInt();
        }
    }

    static void moveRobot(int moveCount, double probability, Position now) {
        if(moveCount == n) {
            ans += probability;
            return;
        }

        for(int drct = 0; drct < 4; drct++) {
            if(probabilities[drct] != 0) {
                int ny = now.y + DY[drct];
                int nx = now.x + DX[drct];

                Position next = new Position(ny, nx);

                if(visit[ny][nx]) continue;

                visit[ny][nx] = true;

                moveRobot(moveCount + 1, probability * probabilities[drct] / 100, next);

                visit[ny][nx] = false;
            }
        }

        visit[now.y][now.x] = false;
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