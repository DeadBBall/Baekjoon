import java.util.*;

public class Main {
    static final Scanner SC = new Scanner(System.in);
    static int startNumber, ans;

    public static void main(String[] args) {
        input();
        countClockNumber();
        System.out.println(ans);
    }
    static void input() {
        String number = SC.nextLine().replace(" ", "");
        number += number;
        startNumber = Integer.MAX_VALUE;
        ans = 1;

        for(int idx = 0; idx < 4; idx++) {
            int num = Integer.parseInt(number.substring(0 + idx, 4 + idx));
            startNumber = Math.min(startNumber, num);
        }
    }

    static void countClockNumber() {
        for(int num = 1111; num < startNumber; num++) {
            if(isClockNumber(num)) ans++;
        }
    }

    static boolean isClockNumber(int num) {
        String number = String.valueOf(num) + String.valueOf(num);

        for(int idx = 0; idx < 4; idx++) {
            int now = Integer.parseInt(number.substring(0 + idx, 4 + idx));

            if(number.charAt(idx) == '0') return false;

            if(num > now) return false;
        }

        return true;
    }
}