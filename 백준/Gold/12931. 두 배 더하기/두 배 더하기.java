import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static List<Integer> numbers;

    public static void main(String[] args) {
        input();
        calculate();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        numbers = new ArrayList<>();

        for(int idx = 0; idx < n; idx++) {
            int num = sc.nextInt();

            if(num != 0) {
                numbers.add(num);
            }
        }

        numbers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
    }

    static void calculate() {
        while(!numbers.isEmpty()) {

            for(int idx = 0; idx < numbers.size(); idx++) {
                if(numbers.get(idx) % 2 == 1) {
                    numbers.set(idx, numbers.get(idx) - 1);
                    ans++;
                }
            }

            numbers.removeIf(num -> num == 0);

            for(int idx = 0; idx < numbers.size(); idx++) {
                numbers.set(idx, numbers.get(idx) / 2);
            }

            if(!numbers.isEmpty()) ans++;
        }
    }
}