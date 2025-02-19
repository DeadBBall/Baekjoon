import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int a, m;

    public static void main(String[] args) {
        input();
        System.out.println(Math.min(a, m) / 2);
    }

    static void input() {
        a = sc.nextInt();
        m = sc.nextInt();
    }
}