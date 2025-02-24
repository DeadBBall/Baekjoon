import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int ans;

    public static void main(String[] args) {
        input();
        System.out.println(ans);
    }

    static void input() {
        int n = sc.nextInt();

        for(int idx = 1; idx <= n; idx++) {
            if(sc.nextInt() != idx) ans++;
        }
    }
}