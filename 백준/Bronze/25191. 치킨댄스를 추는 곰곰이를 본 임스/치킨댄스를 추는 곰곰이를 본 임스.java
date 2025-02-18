import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, a, b;

    public static void main(String[] args) {
        input();
        System.out.println(Math.min(n, a / 2 +  b));
    }

    static void input() {
        n = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
    }
}