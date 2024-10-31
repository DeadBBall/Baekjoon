import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static Set<String> cheese;

    public static void main(String[] args) {
        input();
        makePizza();
        System.out.println(cheese.size() >= 4 ? "yummy" : "sad");
    }

    static void input() {
        n = sc.nextInt();
        cheese = new HashSet<>();
    }

    static void makePizza() {
        while(n-- > 0) {
            String nowCheese = sc.next();

            if(nowCheese.endsWith("Cheese")) {
                cheese.add(nowCheese);
            }
        }
    }
}