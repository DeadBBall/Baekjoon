import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int s, k, h;
    static String ans;

    public static void main(String[] args) {
        input();
        System.out.println(ans);
    }

    static void input() {
        s = sc.nextInt();
        k = sc.nextInt();
        h = sc.nextInt();

        int sum = s + k + h;
        int min = Math.min(Math.min(s, k), h);

        if(sum >= 100) {
            ans = "OK";
        } else {
            if(min == s) {
                ans = "Soongsil";
            } else if(min == k) {
                ans = "Korea";
            } else {
                ans = "Hanyang";
            }
        }
    }
}