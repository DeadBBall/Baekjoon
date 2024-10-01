import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String s;
    static int ans;

    public static void main(String[] args) {
        input();
        abbc();
        System.out.println(ans);
    }

    static void input() {
        s = sc.next();
    }

    static void abbc() {
        Queue<Integer> aQueue = new LinkedList<>();
        Queue<Integer> bQueue = new LinkedList<>();
        Queue<Integer> cQueue = new LinkedList<>();

        for(int idx = 0; idx < s.length(); idx++) {
            char now = s.charAt(idx);

            if(now == 'A') {
                aQueue.add(idx);
            } else if(now == 'B') {
                bQueue.add(idx);
            } else {
                cQueue.add(idx);
            }
        }

        while(!cQueue.isEmpty()) {
            int cIdx = cQueue.remove();

            while(!bQueue.isEmpty() && bQueue.peek() > cIdx && !cQueue.isEmpty()) {
                cIdx = cQueue.remove();
            }

            if(!bQueue.isEmpty() && bQueue.peek() < cIdx) {
                bQueue.remove();
                ans++;
            }
        }

        while(!bQueue.isEmpty()) {
            int bIdx = bQueue.remove();

            while(!aQueue.isEmpty() && aQueue.peek() > bIdx && !bQueue.isEmpty()) {
                bIdx = bQueue.remove();
            }

            if(!aQueue.isEmpty() && aQueue.peek() < bIdx) {
                aQueue.remove();
                ans++;
            }
        }
    }
}