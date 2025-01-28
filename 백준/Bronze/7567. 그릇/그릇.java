import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String bowls;
    static int ans;

    public static void main(String[] args) {
        input();
        measureHeight();
        System.out.println(ans);
    }

    static void input() {
        bowls = sc.next();
    }

    static void measureHeight() {
        char prev = 'a';

        for(int idx = 0; idx < bowls.length(); idx++) {
            if(bowls.charAt(idx) != prev) {
                ans += 10;
            } else {
                ans += 5;
            }

            prev = bowls.charAt(idx);
        }
    }
}