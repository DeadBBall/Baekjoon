import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String s, p;
    static int ans;

    public static void main(String[] args) {
        input();
        makeP();
        System.out.println(ans + 1);
    }

    static void input() {
        s = sc.next();
        p = sc.next();
    }

    static void makeP() {
        int idx = 0;

        for(int i = 0; i < p.length(); i++) {
            if(!s.contains(p.substring(idx, i + 1))) {
                ans++;
                idx = i;
            }
        }
    }
}