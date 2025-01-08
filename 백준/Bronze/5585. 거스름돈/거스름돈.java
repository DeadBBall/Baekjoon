import java.util.*;

public class Main {
    static final int[] coins = {500, 100, 50, 10, 5, 1};
    static Scanner sc = new Scanner(System.in);
    static int change, ans;

    public static void main(String[] args) {
        input();
        giveChange();
        System.out.println(ans);
    }

    static void input() {
        change = 1000 - sc.nextInt();
    }

    static void giveChange() {
        for(int idx = 0; idx < coins.length; idx++) {
            ans += change / coins[idx];

            change %= coins[idx];
        }
    }
}