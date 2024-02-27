import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static boolean canMake;
    static String s, t;

    public static void main(String[] args) {
        input();
        playGame();
        System.out.println(canMake ? 1 : 0);
    }

    static void input() {
        s = sc.next();
        t = sc.next();
    }

    static void playGame() {
        makeStr(new StringBuilder(t));
    }

    static void makeStr(StringBuilder str) {
        if(str.length() == s.length()) {
            if(s.contentEquals(str)){
                canMake = true;
            }
            return;
        }

        if(str.charAt(str.length() - 1) == 'A') {
            str.deleteCharAt(str.length() - 1);
            makeStr(str);
            str.append("A");
        }

        if(str.charAt(0) == 'B') {
            str.deleteCharAt(0);
            str.reverse();

            makeStr(str);
            str.append("B");
            str.reverse();
        }
    }

}