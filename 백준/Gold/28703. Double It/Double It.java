import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int n;
    static PriorityQueue<Long> pq;
    static long ans;
    static long firstMax;
    static long maxNum;

    public static void main(String[] args) {
        input();
        searchMin();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        pq = new PriorityQueue<>();

        for(int cnt = 0; cnt < n; cnt++) {
            long now = sc.nextLong();
            pq.add(now);
            maxNum = Math.max(now, maxNum);
        }
        firstMax = maxNum;
    }

    static void searchMin() {
        ans = maxNum - pq.peek();
        while(true) {
            if(pq.peek() <= 0) break;
            long now = pq.remove() * 2;
            if(now > maxNum) maxNum = now;
            pq.add(now);
            ans = Math.min(ans, maxNum - pq.peek());
            if(pq.peek() > firstMax) break;
        }
    }

}