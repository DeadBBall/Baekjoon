import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String[] s;

    public static void main(String[] args) {
        input();
        System.out.println(countLength());
    }

    static void input() {
        s = sc.next().split("");
    }

    static int countLength() {
        Stack<String> stack = new Stack<>();

        for(int idx = 0; idx < s.length; idx++) {
            if(s[idx].equals(")")) {
                int cnt = 0;

                while(!stack.isEmpty() && !stack.peek().equals("(")) {
                    String top = stack.pop();

                    if(top.equals("+")) {
                        int length = Integer.parseInt(stack.pop());

                        cnt += length;
                    }
                    else cnt++;
                }

                stack.pop();

                cnt *= Integer.parseInt(stack.pop());

                stack.push(String.valueOf(cnt));
                stack.push("+");
            }
            else {
                stack.push(s[idx]);
            }
        }

        int ans = 0;

        while(!stack.isEmpty()) {
            if(stack.peek().equals("+")) {
                stack.pop();

                ans += Integer.parseInt(stack.pop());
            }
            else {
                stack.pop();
                ans++;
            }
        }

        return ans;
    }

}