import java.util.*;

public class Main {
    static final int[] DY = {-1, 0, 1, 0};
    static final int[] DX = {0, 1, 0, -1};
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker = new StringBuilder();
    static String program;
    static Position turtle;
    static int left, right, up, down, ans;

    public static void main(String[] args) {
        int t = sc.nextInt();
        while(t-- > 0) {
            input();
            runProgram();
        }
        System.out.print(ansMaker);
    }
    static void input() {
        program = sc.next();
        turtle = new Position(0, 0, 0);
        ans = left = right = up = down = 0;
    }

    static void runProgram() {
        for(int programIdx = 0; programIdx < program.length(); programIdx++) {
            char now = program.charAt(programIdx);
            switch (now) {
                case 'F':
                    turtle.y += DY[turtle.drct];
                    turtle.x += DX[turtle.drct];
                    break;
                case 'B':
                    turtle.y -= DY[turtle.drct];
                    turtle.x -= DX[turtle.drct];
                    break;
                case 'L':
                    turtle.drct--;
                    if(turtle.drct == -1) turtle.drct = 3;
                    break;
                default:
                    turtle.drct = (turtle.drct + 1) % 4;
                    break;
            }
            if(turtle.y < up)
                up = turtle.y;
            if(turtle.y > down)
                down = turtle.y;
            if(turtle.x > right)
                right = turtle.x;
            if(turtle.x < left)
                left = turtle.x;
        }
        ans = (right - left) * (down - up);
        ansMaker.append(ans).append("\n");
    }

    static class Position {
        int y;
        int x;
        int drct;

        Position(int y, int x, int drct) {
            this.y = y;
            this.x = x;
            this.drct = drct;
        }
    }
}