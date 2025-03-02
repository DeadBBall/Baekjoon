import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, k, n2, k2;

    public static void main(String[] args) {
        input();
        System.out.println(n * k + n2 * k2);
    }

    static void input() {
        n = sc.nextInt();
        k = sc.nextInt();
        n2 = sc.nextInt();
        k2 = sc.nextInt();
    }
}