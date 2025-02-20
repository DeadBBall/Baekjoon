import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {
        int t = sc.nextInt();

        for(int tc = 1; tc <= t; tc++) {
            input();
        }

        System.out.print(ansMaker);
    }

    static void input() {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int x = sc.nextInt();

        ansMaker.append(a * (x - 1) + b).append("\n");
    }
}