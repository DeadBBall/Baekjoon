import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker = new StringBuilder();
    static int s, n;

    public static void main(String[] args) {
        int t = sc.nextInt();

        while(t-- > 0) {
            input();
            buyCar();
        }

        System.out.print(ansMaker);
    }

    static void input() {
        s = sc.nextInt();
        n = sc.nextInt();
    }

    static void buyCar() {
        while(n-- > 0) {
            int q = sc.nextInt();
            int p = sc.nextInt();

            s += q * p;
        }

        ansMaker.append(s).append("\n");
    }
}