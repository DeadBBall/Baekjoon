import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String s;

    public static void main(String[] args) {
        input();
        System.out.println(s.substring(s.length() - 5));
    }

    static void input() {
        sc.nextInt();
        s = sc.next();
    }
}