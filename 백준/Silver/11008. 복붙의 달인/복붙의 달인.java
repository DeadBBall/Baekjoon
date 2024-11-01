import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String s, p;
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {
        int t = sc.nextInt();

        while(t-- > 0) {
            input();
            typing();
        }

        System.out.print(ansMaker);
    }

    static void input() {
        s = sc.next();
        p = sc.next();
    }

    static void typing() {
        int ans = 0;

        while(true) {
            int idx = s.indexOf(p);

            if(idx == -1) break;

            s = s.substring(0, idx) + s.substring(idx + p.length());
            ans++;
        }

        ansMaker.append(ans + s.length()).append("\n");
    }
}