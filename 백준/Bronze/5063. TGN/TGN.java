import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker = new StringBuilder();
    static int r, e, c;

    public static void main(String[] args) {
        int n = sc.nextInt();

        while(n-- > 0) {
            input();
            decide();
        }

        System.out.print(ansMaker);
    }

    static void input() {
        r = sc.nextInt();
        e = sc.nextInt();
        c = sc.nextInt();
    }

    static void decide() {
        if(e - c > r) {
            ansMaker.append("advertise");
        } else if(e - c < r) {
            ansMaker.append("do not advertise");
        } else {
            ansMaker.append("does not matter");
        }

        ansMaker.append("\n");
    }

}