import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int f, s;

    public static void main(String[] args) {
        input();
        System.out.println(s > f ? "flight" : "high speed rail");
    }

    static void input() {
        s = sc.nextInt();
        f = sc.nextInt();
    }

}