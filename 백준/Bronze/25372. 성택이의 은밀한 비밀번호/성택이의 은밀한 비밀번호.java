import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();

        while(n-- > 0) {
            input();
        }

        System.out.print(ansMaker);
    }

    static void input() {
        String password = sc.next();

        if(password.length() >= 6 && password.length() <= 9) {
            ansMaker.append("yes");
        } else {
            ansMaker.append("no");
        }

        ansMaker.append("\n");
    }

}