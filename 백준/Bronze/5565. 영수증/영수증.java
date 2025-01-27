import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int ans;

    public static void main(String[] args) {
        input();
        System.out.println(ans);
    }

    static void input() {
        ans = sc.nextInt();

        for(int idx = 0; idx < 9; idx++) {
            ans -= sc.nextInt();
        }
    }
}