import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int m, ball;

    public static void main(String[] args) {
        input();
        findBall();
        System.out.println(ball);
    }

    static void input() {
        m = sc.nextInt();
        ball = 1;
    }

    static void findBall() {
        while(m-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if(x == ball) {
                ball = y;
            } else if(y == ball) {
                ball = x;
            }
        }
    }
}