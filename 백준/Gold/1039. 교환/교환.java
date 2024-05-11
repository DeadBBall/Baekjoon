import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int[] visit;
    static int k, ans, n;

    public static void main(String[] args) {
        input();
        trade();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        k = sc.nextInt();
        visit = new int[1000001];
        ans = -1;
    }

    static void trade() {
        Queue<Integer> numberQueue = new LinkedList<>();

        numberQueue.add(n);

        int length = 0;

        while(n > 0) {
            n /= 10;
            length++;
        }

        while(!numberQueue.isEmpty() && k > 0) {
            int size = numberQueue.size();

            while(size-- > 0) {
                int now = numberQueue.remove();

                for(int left = 0; left < length - 1; left++) {
                    for(int right = left + 1; right < length; right++) {
                        int next = swap(now, left, right);

                        if(next == 0 || visit[next] == k) continue;

                        numberQueue.add(next);
                        visit[next] = k;
                    }
                }
            }

            k--;
        }

        while(!numberQueue.isEmpty()) {
            ans = Math.max(ans, numberQueue.remove());
        }
    }

    static int swap(int now, int origin, int target) {
        char[] number = String.valueOf(now).toCharArray();

        char tmp = number[origin];
        number[origin] = number[target];
        number[target] = tmp;

        if(number[0] == '0') return 0;

        return Integer.parseInt(String.valueOf(number));
    }
}