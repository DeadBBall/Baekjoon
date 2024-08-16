import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static Ball[] balls;
    static int[] sums;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        catchBall();
        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        balls = new Ball[n];
        sums = new int[n + 1];

        for(int idx = 0; idx < n; idx++) {
            balls[idx] = new Ball(sc.nextInt(), sc.nextInt(), idx + 1);
        }

        Arrays.sort(balls, new Comparator<Ball>() {
            @Override
            public int compare(Ball o1, Ball o2) {
                return o1.value - o2.value;
            }
        });

        ansMaker = new StringBuilder();
    }

    static void catchBall() {
        int sum = 0;
        int prevIdx = 0;

        int[] answers = new int[n + 1];

        for(int idx = 0; idx < n; idx++) {
            Ball now = balls[idx];

            while(balls[prevIdx].value < now.value) {
                sum += balls[prevIdx].value;
                sums[balls[prevIdx].color] += balls[prevIdx].value;
                prevIdx++;
            }

            answers[now.idx] = sum - sums[now.color];
        }

        for(int idx = 1; idx <= n; idx++) {
            ansMaker.append(answers[idx]).append("\n");
        }
    }
}

class Ball {
    int color;
    int value;
    int idx;

    public Ball(int color, int value, int idx) {
        this.color = color;
        this.value = value;
        this.idx = idx;
    }
}