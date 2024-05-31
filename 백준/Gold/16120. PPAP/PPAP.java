import java.util.Scanner;
import java.util.Stack;

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
        Stack<Character> stack = new Stack<>();
        
        for(int strIdx = 0; strIdx < inputStr.length(); strIdx++) {
            char now = inputStr.charAt(strIdx);

            if(now == 'P') stack.push(now);
            else {
                if(stack.size() >= 2 && strIdx < inputStr.length() - 1 && inputStr.charAt(strIdx + 1) == 'P') {
                    stack.pop();
                    stack.pop();
                } else return false;
            }
            
        }
        
        return stack.size() == 1;
    }

}