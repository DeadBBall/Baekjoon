import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static char alp;

    public static void main(String[] args) {
        input();
        System.out.println((alp == 'N' || alp == 'n') ? "Naver D2" : "Naver Whale");
    }

    static void input() {
        alp = sc.next().charAt(0);
    }
}