import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static PriorityQueue<Integer> pq;
    static int n, ans;

    public static void main(String[] args) {
        input();
        clearSnow();
        System.out.println(ans > 1440 ? -1 : ans);
    }

    static void input() {
        pq = new PriorityQueue<>(Comparator.reverseOrder());
        n = sc.nextInt();

        while(n-- > 0) {
            pq.add(sc.nextInt());
        }
    }

    static void clearSnow() {
        while(pq.size() > 1) {
            int snow = pq.remove();
            int snow2 = pq.remove();

            ans += snow2;

            if(snow != snow2) {
                pq.add(snow - snow2);
            }
        }

        if(!pq.isEmpty()) ans += pq.remove();
    }
}