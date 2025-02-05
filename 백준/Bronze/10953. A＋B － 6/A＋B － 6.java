import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {
        int t = sc.nextInt();

        while(t-- > 0) {
            input();
        }

        System.out.print(ansMaker);
    }

    static void input() {
        String inputLine = sc.next();

        ansMaker.append(Integer.parseInt(inputLine.split(",")[0]) +
                Integer.parseInt(inputLine.split(",")[1])).append("\n");
    }

}