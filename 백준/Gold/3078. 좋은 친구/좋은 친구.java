import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, k;
    static Queue<Integer>[] lenQueues;
    static long ans;

    public static void main(String[] args) {
        input();
        countFriends();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        k = sc.nextInt();
        lenQueues = new Queue[21];

        for(int idx = 0; idx < 21; idx++) {
            lenQueues[idx] = new LinkedList<>();
        }
    }

    static void countFriends() {
        int now = 0;

        for(int idx = 0; idx < n; idx++) {
            int nowLen = sc.next().length();

            Queue<Integer> nowQueue = lenQueues[nowLen];

            if(!nowQueue.isEmpty()) {
                while(!nowQueue.isEmpty() && idx - nowQueue.peek() > k) {
                    nowQueue.remove();
                }

                ans += nowQueue.size();
            }

            nowQueue.add(now++);
        }
    }
}