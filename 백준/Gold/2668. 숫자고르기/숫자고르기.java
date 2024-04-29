import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker;
    static int n, setSize;
    static int[] numbers;
    static boolean[] answers;
    static Set<Integer> fromSet, toSet;

    public static void main(String[] args) {
        input();
        makeSet();
        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        numbers = new int[n + 1];
        answers = new boolean[n + 1];

        for(int idx = 1; idx <= n; idx++) {
            numbers[idx] = sc.nextInt();
        }

        ansMaker = new StringBuilder();
        fromSet = new HashSet<>();
        toSet = new HashSet<>();
    }

    static void makeSet() {
        for(int idx = 1; idx <= n; idx++) {
            if(answers[idx]) continue;

            dfs(idx);

            checkSet();

            fromSet.clear();
            toSet.clear();
        }

        ansMaker.append(setSize).append("\n");

        for(int idx = 1; idx <= n; idx++) {
            if(answers[idx]) ansMaker.append(idx).append("\n");
        }
    }

    static void dfs(int now) {
        if(fromSet.contains(now)) return;

        fromSet.add(now);
        toSet.add(numbers[now]);

        dfs(numbers[now]);
    }

    static void checkSet() {
        for(int from : fromSet) {
            if(!toSet.contains(from)) return;
        }

        for(int to : toSet) {
            if(!fromSet.contains(to)) return;
        }

        for(int from : fromSet) {
            answers[from] = true;
            setSize++;
        }
    }

}