import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static boolean[] visit;
    static Set<Integer> ansNumbers;
    static int ansCount;

    public static void main(String[] args) {
        input();
        makeOne(n, new TreeSet<>(Set.of(n)));
        printAns();
    }

    static void input() {
       n = sc.nextInt();
       visit = new boolean[n + 1];
       ansCount = 10000000;

       ansNumbers = new TreeSet<>(Collections.reverseOrder());
       ansNumbers.add(n);
    }

    static void makeOne(int now, Set<Integer> numbers) {
        if(visit[now] && ansCount <= numbers.size()) return;

        visit[now] = true;

        if(now == 1) {
            if(ansCount > numbers.size()) {
                ansCount = numbers.size();
                ansNumbers = new TreeSet<>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer a, Integer b) {
                        return b - a;
                    }
                });
                ansNumbers.addAll(numbers);
            }
            return;
        }

        if(now % 3 == 0) {
            numbers.add(now / 3);
            makeOne(now / 3, numbers);
            numbers.remove(now / 3);
        }
        if(now % 2 == 0) {
            numbers.add(now / 2);
            makeOne(now / 2, numbers);
            numbers.remove(now / 2);
        }
        numbers.add(now - 1);
        makeOne(now - 1, numbers);
        numbers.remove(now - 1);
    }

    static void printAns() {
        System.out.println(ansNumbers.size() - 1);
        ansNumbers.forEach(number -> System.out.print(number + " "));
    }
}