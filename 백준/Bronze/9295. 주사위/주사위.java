import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {
        int t = sc.nextInt();

        for(int tc = 1; tc <= t; tc++) {
            ansMaker.append("Case ").append(tc).append(": ");
            input();
        }

        System.out.print(ansMaker);
    }

    static void input() {
        int sum = sc.nextInt() + sc.nextInt();

        ansMaker.append(sum).append("\n");
    }
}