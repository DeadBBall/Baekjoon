import java.util.*;

public class Main {
    static final int PUSH = 1;
    static final int POP = 2;
    static final int SIZE = 3;
    static final int EMPTY = 4;
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker;
    static int n;
    static MyStack stack;

    public static void main(String[] args) {
        input();
        executeInstructions();
        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        stack = new MyStack(n);
        ansMaker = new StringBuilder();
    }

    static void executeInstructions() {
        for(int instructionIdx = 0; instructionIdx < n; instructionIdx++) {
            int instruction = sc.nextInt();

            switch (instruction) {
                case PUSH:
                    int item = sc.nextInt();
                    stack.push(item);
                    break;
                case POP:
                    ansMaker.append(stack.pop()).append("\n");
                    break;
                case SIZE:
                    ansMaker.append(stack.size()).append("\n");
                    break;
                case EMPTY:
                    ansMaker.append(stack.empty()).append("\n");
                    break;
                default:
                    ansMaker.append(stack.peek()).append("\n");
            }
        }
    }

}

class MyStack {
    int[] arr;
    int now;

    MyStack(int size) {
        arr = new int[size];
        now = -1;
    }

    void push(int item) {
        arr[++now] = item;
    }

    int pop() {
        if(now == -1) return -1;

        return arr[now--];
    }

    int size() {
        return now + 1;
    }

    int empty() {
        return now == -1 ? 1 : 0;
    }

    int peek() {
        return now == -1 ? -1 : arr[now];
    }
}