import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String s;

    public static void main(String[] args) {
        input();
        System.out.println(makeNewS());
    }

    static void input() {
        s = sc.next();
    }

    static String makeNewS() {
        StringBuilder ansMaker = new StringBuilder();

        int zeroCnt = 0;
        int oneCnt = 0;

        for(int idx = 0; idx < s.length(); idx++) {
            if(s.charAt(idx) == '0') zeroCnt++;
            else oneCnt++;
        }

        zeroCnt /= 2;
        oneCnt /= 2;

        boolean[] deleteFlag = new boolean[s.length()];

        for(int idx = s.length() - 1; idx >= 0; idx--) {
            if(s.charAt(idx) == '0' && zeroCnt > 0) {
                deleteFlag[idx] = true;

                zeroCnt--;

                if(zeroCnt == 0) break;
            }
        }

        for(int idx = 0; idx < s.length(); idx++) {
            if(s.charAt(idx) == '1' && oneCnt > 0) {
                oneCnt--;
            } else {
                if(!deleteFlag[idx]) ansMaker.append(s.charAt(idx));
            }
        }

        return ansMaker.toString();
    }

}