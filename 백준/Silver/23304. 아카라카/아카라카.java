import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String s;

    public static void main(String[] args) {
        input();
        System.out.println(isAkaraka(s) ? "AKARAKA" : "IPSELENTI");
    }

    static void input() {
        s = sc.next();
    }

    static boolean isAkaraka(String str) {
        if(str.length() == 1) return true;

        String prefix = str.substring(0, str.length() / 2);
        String suffix = str.substring((str.length() + 1) / 2);

        for(int idx = 0; idx < str.length() / 2; idx++) {
            if(str.charAt(idx) != str.charAt(str.length() - 1 - idx)) return false;
        }

        return isAkaraka(prefix) && isAkaraka(suffix);
    }
}