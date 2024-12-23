import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int[] numbers;
    static long ans;

    public static void main(String[] args) {
        input();
        makeSameNumber();
        System.out.print(ans);
    }

    static void input() {
        n = sc.nextInt();
        numbers = new int[n];

        for(int idx = 0; idx < n; idx++) {
            numbers[idx] = sc.nextInt();
        }
    }

    static void makeSameNumber() {
        Stack<Long> numStack = new Stack<>();
        long max = 0;

        for(int idx = 0; idx < n; idx++) {
            long now = numbers[idx];

            max = Math.max(max, now);

            if(numStack.isEmpty()) {
                numStack.add(now);
            } else {
                if(numStack.peek() < now) {
                    ans += now - numStack.pop();
                    numStack.add(now);
                } else if(numStack.peek() > now) {
                    numStack.pop();
                    numStack.add(now);
                }
            }

        }

        while(!numStack.isEmpty()) {
            ans += max - numStack.pop();
        }
    }

}