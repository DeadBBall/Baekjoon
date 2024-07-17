import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static long n;

    public static void main(String[] args) {
        input();
        System.out.print(playGame() ? "CY" : "SK");
    }

    static void input() {
        n = sc.nextLong();
    }

    static boolean playGame() {
        return n % 5 == 2 || n % 5 == 0;
    }
}