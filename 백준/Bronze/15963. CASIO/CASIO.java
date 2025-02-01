import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static long n, m;

    public static void main(String[] args) {
        input();
        System.out.println(n == m ? 1 : 0);
    }

    static void input() {
        n = sc.nextLong();
        m = sc.nextLong();
    }
}