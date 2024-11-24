import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String numbers;
    static int ans;

    public static void main(String[] args) {
        input();
        writeNumber();
        System.out.println(ans);
    }

    static void input() {
        numbers = sc.next();
    }

    static void writeNumber() {
        int idx = 0;

        for(int num = 1; idx < numbers.length(); num++) {
            String numStr = String.valueOf(num);

            for(int numIdx = 0; numIdx < numStr.length(); numIdx++) {
                if(numbers.charAt(idx) == numStr.charAt(numIdx)) {
                    idx++;

                    if(idx >= numbers.length()) break;
                }
            }

            ans = num;
        }
    }
}