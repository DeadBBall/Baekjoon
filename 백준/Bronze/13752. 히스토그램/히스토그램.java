import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker = new StringBuilder();
    static int k;

    public static void main(String[] args) {
        int n = sc.nextInt();

        while(n-- > 0) {
            input();
            paint();
        }

        System.out.print(ansMaker);
    }

    static void input() {
        k = sc.nextInt();
    }

    static void paint() {
        for(int idx = 0; idx < k; idx++) {
            ansMaker.append("=");
        }

        ansMaker.append("\n");
    }
}