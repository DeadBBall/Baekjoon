import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String l, r;
    static int ans;

    public static void main(String[] args) {
        input();
        countEight();
        System.out.println(ans);
    }
    static void input() {
        l = sc.next();
        r = sc.next();
    }

    static void countEight() {
        if(l.length() != r.length()) return;
        for(int idx = 0; idx < l.length(); idx++) {
            char nowL = l.charAt(idx);
            char nowR = r.charAt(idx);
            if(nowL == '8' && nowR == '8')
                ans++;
            else if(nowL != nowR) return;
        }
    }

}