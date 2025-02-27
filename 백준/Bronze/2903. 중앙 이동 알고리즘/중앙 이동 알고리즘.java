import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;

    public static void main(String[] args) {
        input();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        ans = 3;

        for(int idx = 1; idx < n; idx++) {
            ans = ans * 2 - 1;
        }

        ans *= ans;
    }
}