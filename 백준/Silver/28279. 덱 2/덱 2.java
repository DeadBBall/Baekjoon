import java.util.*;

public class Main {
    static final Scanner SC = new Scanner(System.in);
    static final int ADDFIRST = 1;
    static final int ADDLAST = 2;
    static final int REMOVEFIRST = 3;
    static final int REMOVELAST = 4;
    static final int SIZE = 5;
    static final int ISEMPTY = 6;
    static final int PEEKFIRST = 7;
    static final int PEEKLAST = 8;
    static StringBuilder ansMaker;
    static int n;

    public static void main(String[] args) {
        input();
        useDeque();
        System.out.println(ansMaker);
    }
    static void input() {
        n = SC.nextInt();
        ansMaker = new StringBuilder();
    }

    static void useDeque() {
        MyDeque deque = new MyDeque(n);

        while(n-- >0) {
            int command = SC.nextInt();

            switch (command) {
                case ADDFIRST -> {
                    int element = SC.nextInt();
                    deque.addFirst(element);
                }
                case ADDLAST -> {
                    int element = SC.nextInt();
                    deque.addLast(element);
                }
                case REMOVEFIRST -> {
                    ansMaker.append(deque.removeFirst()).append("\n");
                }
                case REMOVELAST -> {
                    ansMaker.append(deque.removeLast()).append("\n");
                }
                case SIZE -> {
                    ansMaker.append(deque.size()).append("\n");
                }
                case ISEMPTY -> {
                    ansMaker.append(deque.isEmpty() ? 1 : 0).append("\n");
                }
                case PEEKFIRST -> {
                    ansMaker.append(deque.peekFirst()).append("\n");
                }
                case PEEKLAST -> {
                    ansMaker.append(deque.peekLast()).append("\n");
                }
            }
        }
    }
}

class MyDeque {
    int left;
    int right;
    int[] arr;

    public MyDeque(int size) {
        this.left = size;
        this.right = size;
        this.arr = new int[size * 2];
    }

    void addFirst(int element) {
        arr[left--] = element;
    }

    void addLast(int element) {
        arr[++right] = element;
    }

    int removeFirst() {
        if(left == right) return -1;

        return arr[++left];
    }

    int removeLast() {
        if(left == right) return -1;

        return arr[right--];
    }

    int size() {
        return right - left;
    }

    boolean isEmpty() {
        return right - left == 0;
    }

    int peekFirst() {
        return left == right ? -1 : arr[left + 1];
    }

    int peekLast() {
        return left == right ? -1 : arr[right];
    }
}
