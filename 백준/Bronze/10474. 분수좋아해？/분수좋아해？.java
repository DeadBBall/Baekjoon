import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker = new StringBuilder();
    static int denominator, numerator;

    public static void main(String[] args) {
        while(true) {
            input();

            if(denominator == 0 && numerator == 0) break;

            calculate();
        }

        System.out.print(ansMaker);
    }

    static void input() {
        denominator = sc.nextInt();
        numerator = sc.nextInt();
    }

    static void calculate() {
        ansMaker.append(denominator / numerator).append(" ");
        ansMaker.append(denominator % numerator).append(" / ").append(numerator).append("\n");
    }
}