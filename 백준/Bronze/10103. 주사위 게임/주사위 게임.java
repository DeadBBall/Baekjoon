import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int cy, sd, n;

    public static void main(String[] args) {
        input();
        playGame();
        System.out.println(cy);
        System.out.println(sd);
    }

    static void input() {
        n = sc.nextInt();
        cy = sd = 100;
    }

    static void playGame() {
        while(n-- > 0) {
            int cyDice = sc.nextInt();
            int sdDice = sc.nextInt();

            if(cyDice > sdDice) {
                sd -= cyDice;
            } else if(cyDice < sdDice) {
                cy -= sdDice;
            }
        }
    }
}