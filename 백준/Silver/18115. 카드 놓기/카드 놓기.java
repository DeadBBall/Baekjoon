import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static StringBuilder ansMaker;
    static Deque<Integer> nums;
    static int[] orders;

    public static void main(String[] args) {
        input();
        setCard();
        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        orders = new int[n];

        for(int idx = 0; idx < n; idx++) {
            orders[idx] = sc.nextInt();
        }

        nums = new ArrayDeque<>();
        ansMaker = new StringBuilder();
    }

    static void setCard() {
        while(n-- > 0) {
            int order = orders[n];

            if(order == 1){
                nums.addFirst(orders.length - n);
            } else if(order == 2) {
                int first = nums.removeFirst();

                nums.addFirst(orders.length - n);
                nums.addFirst(first);
            } else {
                nums.addLast(orders.length - n);
            }
        }

        nums.forEach(num -> ansMaker.append(num).append(" "));
    }
}