import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {
        int t = sc.nextInt();

        while(t-- > 0) {
            input();
        }

        System.out.print(ansMaker);
    }

    static void input() {
        int x = sc.nextInt();
        int y = sc.nextInt();

        ansMaker.append(x + y).append("\n");
    }
}