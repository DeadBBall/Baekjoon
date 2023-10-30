import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static final char PERSON = 'P';
    static final char BURGER = 'H';
    static int n, k, ans;
    static String line;
    static boolean[] visit;

    public static void main(String[] args) {
        input();
        eatBurger();
        System.out.println(ans);
    }
    static void input() {
        n = sc.nextInt();
        k = sc.nextInt();
        line = sc.next();
        visit = new boolean[n];
    }

    static void eatBurger() {
        for(int idx = 0; idx < n; idx++) {
            if(line.charAt(idx) == PERSON) {
                for(int hIdx = idx - k; hIdx <= idx + k && hIdx < n; hIdx++) {
                    if(hIdx < 0) continue;
                    if(line.charAt(hIdx) == BURGER && !visit[hIdx]) {
                        visit[hIdx] = true;
                        ans++;
                        break;
                    }
                }
            }
        }
    }

}