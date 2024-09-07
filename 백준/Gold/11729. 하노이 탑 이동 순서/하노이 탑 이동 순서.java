import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        hanoi(n, 1, 2, 3);
        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        ansMaker = new StringBuilder();
        ansMaker.append((int)Math.pow(2, n) - 1).append("\n");
    }

    static void hanoi(int cnt, int start, int mid, int end) {
        if(cnt == 1) {
            ansMaker.append(start).append(" ").append(end).append("\n");
            return;
        }

        hanoi(cnt - 1, start, end, mid);

        ansMaker.append(start).append(" ").append(end).append("\n");

        hanoi(cnt - 1, mid, start, end);
    }

}