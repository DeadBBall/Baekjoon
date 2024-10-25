import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static long n;
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {
        int t = sc.nextInt();

        while(t-- > 0) {
            input();
            ansMaker.append(countRope()).append("\n");
        }

        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextLong();
    }

    static long countRope() {
        return (n + 1) / 2 + (n + 1) / 2 - ((n - 1) / 3 + 1) / 2;
    }
}