import java.util.*;

public class Main {
    static final char PLUS = '+';
    static final char MINUS = '-';
    static final char SPACE = ' ';
    static Scanner sc = new Scanner(System.in);
    static int n;
    static char[] signs;
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {
        int t = sc.nextInt();

        while(t-- > 0) {
            input();
            makeZero(0);
            ansMaker.append("\n");
        }

        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        signs = new char[n - 1];
    }

    static void makeZero(int idx) {
        if(idx == n - 1) {
            if(isZero()) {
                for(int signIdx = 0; signIdx < n - 1; signIdx++) {
                    ansMaker.append(signIdx + 1).append(signs[signIdx]);
                }
                ansMaker.append(n).append("\n");
            }
            return;
        }

        signs[idx] = SPACE;
        makeZero(idx + 1);

        signs[idx] = PLUS;
        makeZero(idx + 1);

        signs[idx] = MINUS;
        makeZero(idx + 1);
    }

    static boolean isZero() {
        int result = 0;
        StringBuilder now = new StringBuilder();

        for(int signIdx = n - 2; signIdx >= 0; signIdx--) {
            now.insert(0, signIdx + 2);
            if(signs[signIdx] == PLUS) {
                result += Integer.parseInt(now.toString());
                now.setLength(0);
            }
            else if(signs[signIdx] == MINUS) {
                result -= Integer.parseInt(now.toString());
                now.setLength(0);
            }
        }
        now.insert(0, 1);
        result += Integer.parseInt(now.toString());

        return result == 0;
    }
}