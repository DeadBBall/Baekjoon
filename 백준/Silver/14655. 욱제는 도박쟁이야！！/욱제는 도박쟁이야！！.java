import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;

    public static void main(String[] args) {
        input();
        turnOverCoin();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
    }

    static void turnOverCoin() {
        for(int idx = 0; idx < n * 2; idx++) {
            ans += Math.abs(sc.nextInt());
        }
    }
}