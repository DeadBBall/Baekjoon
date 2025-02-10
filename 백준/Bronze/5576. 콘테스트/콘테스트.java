import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int w, k;

    public static void main(String[] args) {
        input();
        System.out.println(w + " " + k);
    }

    static void input() {
        PriorityQueue<Integer> wScores = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> kScores = new PriorityQueue<>(Comparator.reverseOrder());

        for(int idx = 0; idx < 10; idx++) {
            wScores.add(sc.nextInt());
        }

        for(int idx = 0; idx < 10; idx++) {
            kScores.add(sc.nextInt());
        }

        for(int idx = 0; idx < 3; idx++) {
            w += wScores.remove();
            k += kScores.remove();
        }
    }
}