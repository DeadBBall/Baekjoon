import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String s, p;
    static int ans;

    public static void main(String[] args) {
        input();
        makeP();
        System.out.println(ans);
    }

    static void input() {
        s = sc.next();
        p = sc.next();
    }

    static void makeP() {
        for(int i = 0; i < p.length(); i++) {
            for(int j = p.length(); j > i; j--) {
                if(s.contains(p.substring(i, j))) {
                    i += (j - i) - 1;
                    ans++;
                    break;
                }
            }
        }
    }

}