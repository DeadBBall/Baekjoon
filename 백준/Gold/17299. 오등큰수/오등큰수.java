import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] numbers;
    static Map<Integer, Integer> counts;
    static StringBuilder ansMaker;

    public static void main(String[] args) throws IOException {
        input();
        findNumber();
        System.out.print(ansMaker);
    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        counts = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int idx = 0; idx < n; idx++) {
            int num = Integer.parseInt(st.nextToken());

            counts.put(num, counts.getOrDefault(num, 0) + 1);
            numbers[idx] = num;
        }

        ansMaker = new StringBuilder();
    }

    static void findNumber() {
        Stack<Integer> numStack = new Stack<>();
        int[] answers = new int[n];

        for(int idx = 0; idx < n; idx++) {
            while(!numStack.isEmpty() && counts.get(numbers[numStack.peek()]) < counts.get(numbers[idx])) {
                answers[numStack.pop()] = numbers[idx];
            }

            numStack.add(idx);
        }

        while(!numStack.isEmpty()) {
            answers[numStack.pop()] = -1;
        }

        for(int answer : answers) {
            ansMaker.append(answer).append(" ");
        }
    }
}