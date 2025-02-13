import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;

    public static void main(String[] args) {
        input();
        calculate();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
    }

    static void calculate() {
        String num = String.valueOf(n);

        for(int i = 0; i < num.length(); i++) {
            ans += (int)Math.pow(num.charAt(i) - '0', 5);
        }
    }
}