import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static String s;

    public static void main(String[] args) {
        input();
        System.out.println(makeWord());
    }

    static void input() {
        n = sc.nextInt();
        s = sc.next();
    }

    static int makeWord() {
        return 25 * n + 26;
    }

}