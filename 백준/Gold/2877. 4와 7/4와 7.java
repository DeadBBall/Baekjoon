import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int k;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        searchNumber();
        System.out.print(ansMaker);
    }

    static void input() {
        k = sc.nextInt();
        ansMaker = new StringBuilder();
    }

    static void searchNumber() {
        while(k > 0) {
            k--;
            if(k % 2 == 1) {
                ansMaker.insert(0, 7);
            } else {
                ansMaker.insert(0, 4);
            }
            k /= 2;
        }
    }
}