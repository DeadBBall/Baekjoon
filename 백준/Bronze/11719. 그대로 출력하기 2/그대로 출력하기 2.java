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
        while(sc.hasNextLine()) {
            ansMaker.append(sc.nextLine()).append("\n");
        }
    }
}