import java.util.*;

public class Main {
    static final double PI = 3.141592;
    static Scanner sc = new Scanner(System.in);
    static double ans;

    public static void main(String[] args) {
        input();
        System.out.println(ans);
    }

    static void input() {
        int d = sc.nextInt();
        int d2 = sc.nextInt();

        ans = d2 * 2 * PI + d * 2;
    }
}