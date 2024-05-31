import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String inputStr;

    public static void main(String[] args) {
        input();
        System.out.println(checkPPAP() ? "PPAP" : "NP");
    }

    static void input() {
        inputStr = sc.next();
    }

    static boolean checkPPAP() {
        int cnt = 0;

        for(int strIdx = 0; strIdx < inputStr.length(); strIdx++) {
            char now = inputStr.charAt(strIdx);

            if(now == 'P') cnt++;
            else if(now == 'A' && cnt >= 2) {
                if(strIdx < inputStr.length() - 1 && inputStr.charAt(strIdx + 1) == 'P') {
                    cnt--;
                    strIdx++;
                } else return false;
            }
            else return false;
        }

        return cnt == 1;
    }

}