import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static Stack<Integer> numbers;
    static Map<Integer, Integer> counts;
    static StringBuilder ansMaker;

    public static void main(String[] args) throws IOException {
        input();
        findNumber();
        System.out.print(ansMaker);
    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        counts = new HashMap<>();
        numbers = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int idx = 0; idx < n; idx++) {
            int num = Integer.parseInt(st.nextToken());

            counts.put(num, counts.getOrDefault(num, 0) + 1);
            numbers.push(num);
        }

        ansMaker = new StringBuilder();
    }

    static void findNumber() {
        Stack<Integer> rightNumbers = new Stack<>();
        List<Integer> answers = new ArrayList<>();

        while(!numbers.isEmpty()) {
            int now = numbers.pop();

            while(!rightNumbers.isEmpty() && counts.get(rightNumbers.peek()) <= counts.get(now)) {
                rightNumbers.pop();
            }
            answers.add(rightNumbers.isEmpty() ? -1 : rightNumbers.peek());
            rightNumbers.add(now);
        }

        for(int idx = answers.size() - 1; idx >= 0; idx--) {
            ansMaker.append(answers.get(idx)).append(" ");
        }
    }
}