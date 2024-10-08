import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static List<Integer> numbers;

    public static void main(String[] args) {
        input();
        cutLine();
        System.out.println(n - numbers.size());
    }

    static void input() {
        n = sc.nextInt();
        numbers = new ArrayList<>();
        numbers.add(n + 1);
    }

    static void cutLine() {
        for(int idx = 0; idx < n; idx++) {
            int now = sc.nextInt();

            if(numbers.get(numbers.size() - 1) < now) {
                numbers.add(now);
            } else {
                int left = 0;
                int right = numbers.size();

                while(left < right) {
                    int mid = (left + right) >> 1;

                    if(numbers.get(mid) < now) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                numbers.set(right, now);
            }
        }
    }
}