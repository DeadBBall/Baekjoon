import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static final char OPEN = '(';
    static final char CLOSE = ')';
    static String parentheses;
    static int ans;

    public static void main(String[] args) {
        input();
        putParentheses();
        System.out.println(ans);
    }

    static void input() {
        parentheses = sc.next();
    }

    static void putParentheses() {
        int openCount = 0;

        for(char parenthesis : parentheses.toCharArray()) {
            if(parenthesis == OPEN) {
                openCount++;
            }
            else if(parenthesis == CLOSE) {
                if(openCount > 0) openCount--;
                else ans++;
            }
        }
        ans += openCount;
    }

}