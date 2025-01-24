import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        change();
        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        ansMaker = new StringBuilder();
    }

    static void change() {
        while(n-- > 0) {
            String si = sc.next();

            ansMaker.append(si.toLowerCase()).append("\n");
        }
    }
}