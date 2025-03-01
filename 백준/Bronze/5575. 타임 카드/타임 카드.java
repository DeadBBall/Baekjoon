import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        System.out.println(ansMaker);
    }

    static void input() {
        ansMaker = new StringBuilder();

        for(int i = 0; i < 3; i++) {
            int startTime = (sc.nextInt() * 60 + sc.nextInt()) * 60 + sc.nextInt();
            int endTime = (sc.nextInt() * 60 + sc.nextInt()) * 60 + sc.nextInt();
            int diff = endTime - startTime;

            int s = diff % 60;
            int m = diff / 60 % 60;
            int h = diff / 60 / 60;

            ansMaker.append(h).append(" ").append(m).append(" ").append(s).append("\n");
        }
    }
}