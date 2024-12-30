import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;

    public static void main(String[] args) {
        input();
        System.out.println(clear() ? "YES" : "NO");
    }

    static void input() {
        n = sc.nextInt();
    }

    static boolean clear() {
        Stack<Integer>[] stacks = new Stack[4];

        for(int idx = 0; idx < 4; idx++) {
            stacks[idx] = new Stack<>();
        }

        while(n-- > 0) {
            int num = sc.nextInt();

            boolean flag = false;

            for(int idx = 0; idx < 4; idx++) {
                if(!stacks[idx].isEmpty() && stacks[idx].peek() < num) {
                    stacks[idx].push(num);
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                for(int idx = 0; idx < 4; idx++) {
                    if(stacks[idx].isEmpty()) {
                        stacks[idx].push(num);
                        flag = true;
                        break;
                    }
                }
            }

            if(!flag) return false;
        }

        return true;
    }
}