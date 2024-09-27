import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static Set<Long> numberSet;
    static long[] numbers;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        playGame();
        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        numbers = new long[n];
        numberSet = new HashSet<>();

        for(int idx = 0; idx < n; idx++) {
            numbers[idx] = sc.nextLong();
            numberSet.add(numbers[idx]);
        }

        Arrays.sort(numbers);
        ansMaker = new StringBuilder();
    }

    static void playGame() {
        for(int idx = n - 1; idx >= 0; idx--) {
            calculate(numbers[idx], new HashSet<>(Set.of(numbers[idx])), new ArrayList<>(List.of(numbers[idx])));

            if(!ansMaker.isEmpty()) break;
        }
    }

    static void calculate(long now, Set<Long> visit, List<Long> answers) {
        visit.add(now);

        if(visit.size() == numberSet.size()) {
            answers.forEach(ans -> ansMaker.append(ans).append(" "));
            return;
        }

        if(!ansMaker.isEmpty()) return;

        if(now % 3 == 0 && numberSet.contains(now / 3)) {
            visit.add(now / 3);
            answers.add(now / 3);

            calculate(now / 3, visit, answers);

            visit.remove(now / 3);
            answers.remove(answers.size() - 1);
        }

        if(!ansMaker.isEmpty()) return;

        if(numberSet.contains(now * 2)) {
            visit.add(now * 2);
            answers.add(now * 2);

            calculate(now * 2, visit, answers);

            visit.remove(now * 2);
            answers.remove(answers.size() - 1);
        }
    }
}