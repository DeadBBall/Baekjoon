import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int b, c, d, totalPrice, discountedPrice;
    static Integer[] burgers, sides, drinks;

    public static void main(String[] args) {
        input();
        calculatePrice();
        System.out.println(totalPrice);
        System.out.println(discountedPrice);
    }

    static void input() {
        b = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();

        burgers = new Integer[b];
        sides = new Integer[c];
        drinks = new Integer[d];

        for(int idx = 0; idx < b; idx++) {
            burgers[idx] = sc.nextInt();
            totalPrice += burgers[idx];
            discountedPrice += burgers[idx];
        }

        for(int idx = 0; idx < c; idx++) {
            sides[idx] = sc.nextInt();
            totalPrice += sides[idx];
            discountedPrice += sides[idx];
        }

        for(int idx = 0; idx < d; idx++) {
            drinks[idx] = sc.nextInt();
            totalPrice += drinks[idx];
            discountedPrice += drinks[idx];
        }

        Arrays.sort(burgers, Collections.reverseOrder());
        Arrays.sort(sides, Collections.reverseOrder());
        Arrays.sort(drinks, Collections.reverseOrder());
    }

    static void calculatePrice() {
        int setIdx = Math.min(b, Math.min(c, d));

        for(int idx = 0; idx < setIdx; idx++) {
            discountedPrice -= (int) (burgers[idx] * 0.1);
            discountedPrice -= (int) (sides[idx] * 0.1);
            discountedPrice -= (int) (drinks[idx] * 0.1);
        }
    }

}