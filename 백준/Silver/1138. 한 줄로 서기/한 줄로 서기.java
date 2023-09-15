import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int[] lines;
    static List<Integer> ans;

    public static void main(String[] args) {
        input();
        lineUp();
        ans.forEach(num -> System.out.print(num + " "));
    }

    static void input() {
        n = sc.nextInt();
        lines = new int[n + 1];
        ans = new ArrayList<>();

        for(int lineIdx = 1; lineIdx <= n; lineIdx++) {
            lines[lineIdx] = sc.nextInt();
        }
    }

    static void lineUp() {
        for(int idx = n; idx > 0; idx--) {
            ans.add(lines[idx], idx);
        }
    }
}