import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static long n;
    static String ans;

    public static void main(String[] args) {
        input();
        playGame();
        System.out.println(ans);
    }
    static void input() {
        n = sc.nextLong();
    }

    static void playGame() {
        ans = n % 2 == 0 ? "CY" : "SK";
    }
}