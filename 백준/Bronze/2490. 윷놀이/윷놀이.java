import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int[] yuts;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        playYut();
        System.out.print(ansMaker);
    }

    static void input() {
        yuts = new int[3];
        ansMaker = new StringBuilder();
    }

    static void playYut() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                int yut = sc.nextInt();

                yuts[i] += yut;
            }

            switch (yuts[i]) {
                case 1:
                    ansMaker.append("C");
                    break;
                case 2:
                    ansMaker.append("B");
                    break;
                case 3:
                    ansMaker.append("A");
                    break;
                case 4:
                    ansMaker.append("E");
                    break;
                default:
                    ansMaker.append("D");
            }

            ansMaker.append("\n");
        }
    }
}