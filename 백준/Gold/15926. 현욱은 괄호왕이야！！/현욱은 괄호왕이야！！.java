import java.util.*;

public class Main {
    static final char RIGHT = ')';
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static String parentheses;

    public static void main(String[] args) {
        input();
        findLongParentheses();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        parentheses = sc.next();
    }

    static void findLongParentheses() {
        Stack<Integer> stack = new Stack<>();
        boolean[] check = new boolean[n];

        for(int idx = 0; idx < n; idx++) {
            char now = parentheses.charAt(idx);

            if(now == RIGHT) {
                if(!stack.isEmpty()) {
                    check[stack.pop()] = true;
                    check[idx] = true;
                }
            } else {
                stack.add(idx);
            }
        }

        int cnt = 0;

        for(int idx = 0; idx < n; idx++) {
            if(check[idx]) {
                cnt++;
            } else {
                cnt = 0;
            }

            if(cnt > 0) ans = Math.max(ans, cnt);
        }
    }
}