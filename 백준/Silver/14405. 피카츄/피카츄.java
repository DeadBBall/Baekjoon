import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String s;

    public static void main(String[] args){
        input();
        System.out.println(isPikachu() ? "YES" : "NO");
    }

    static void input() {
        s = sc.next();
    }

    static boolean isPikachu() {
        for(int idx = 0; idx < s.length(); idx++) {
            char now = s.charAt(idx);

            if(now == 'p') {
                if(idx + 1 >= s.length() || s.charAt(idx + 1) != 'i') return false;

                idx++;
            } else if(now == 'k') {
                if(idx + 1 >= s.length() || s.charAt(idx + 1) != 'a') return false;

                idx++;
            } else if(now == 'c') {
                if(idx + 2 >= s.length() || s.charAt(idx + 1) != 'h' || s.charAt(idx + 2) != 'u') return false;

                idx += 2;
            } else return false;
        }

        return true;
    }

}