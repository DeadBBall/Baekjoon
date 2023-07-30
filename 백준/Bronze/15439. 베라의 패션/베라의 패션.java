import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static void input() {
        n = sc.nextInt();
    }

    public static void main(String[] args) {
        input();
        System.out.println(n * (n - 1));
    }
}