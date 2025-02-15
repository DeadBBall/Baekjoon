import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String s;

    public static void main(String[] args) {
        input();
        System.out.println(s.split(",").length);
    }

    static void input() {
        s = sc.next();
    }
}