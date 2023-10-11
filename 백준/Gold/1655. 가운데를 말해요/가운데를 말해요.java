import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static StringBuilder ansMaker;
    static PriorityQueue<Integer> minPriorityQueue;
    static PriorityQueue<Integer> maxPriorityQueue;

    public static void main(String[] args) {
        input();
        tellMiddle();
        System.out.println(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        ansMaker = new StringBuilder();
        minPriorityQueue = new PriorityQueue<>();
        maxPriorityQueue = new PriorityQueue<>(Collections.reverseOrder());
    }

    static void tellMiddle() {
        for(int idx = 0; idx < n; idx++) {
            int nowNumber = sc.nextInt();
            if(idx == 0) {
                maxPriorityQueue.add(nowNumber);
                ansMaker.append(nowNumber).append("\n");
            }
            else if(maxPriorityQueue.size() > minPriorityQueue.size()) {
                if(maxPriorityQueue.peek() > nowNumber) {
                    minPriorityQueue.add(maxPriorityQueue.remove());
                    maxPriorityQueue.add(nowNumber);
                }
                else
                    minPriorityQueue.add(nowNumber);
                ansMaker.append(maxPriorityQueue.peek()).append("\n");
            }
            else{
                if(minPriorityQueue.peek() < nowNumber) {
                    maxPriorityQueue.add(minPriorityQueue.remove());
                    minPriorityQueue.add(nowNumber);
                }
                else
                    maxPriorityQueue.add(nowNumber);
                ansMaker.append(maxPriorityQueue.peek()).append("\n");
            }
        }
    }
}