import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static StringBuilder sb = new StringBuilder();

    static void input() {
        n = sc.nextInt();
    }

    static void print() {
        for(int i = 0; i < n / 4; i++) {
            sb.append("long ");
        }
        sb.append("int");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        print();
    }
}