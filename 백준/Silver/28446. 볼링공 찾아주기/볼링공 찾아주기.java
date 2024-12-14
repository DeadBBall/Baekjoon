import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int m;
    static Map<Integer, Integer> locker;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        findBall();
        System.out.print(ansMaker);
    }

    static void input() {
        m = sc.nextInt();
        locker = new HashMap<>();
        ansMaker = new StringBuilder();
    }

    static void findBall() {
        while(m-- > 0) {
            int order = sc.nextInt();

            if(order == 1) {
                int pos = sc.nextInt();
                int weight = sc.nextInt();

                locker.put(weight, pos);
            } else {
                int weight = sc.nextInt();

                ansMaker.append(locker.get(weight)).append("\n");
            }
        }
    }
}