import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static List<Integer> numbers;
    static int n;

    public static void main(String[] args) {
        input();
        countPort();
        System.out.println(numbers.size());
    }

    static void input() {
        n = sc.nextInt();
        numbers = new ArrayList<>();
        numbers.add(n + 1);
    }

    static void countPort() {
        while(n-- > 0) {
            int port = sc.nextInt();

            if(numbers.get(numbers.size() - 1) < port) {
                numbers.add(port);
            } else {
                int left = 0;
                int right = numbers.size();

                while(left < right) {
                    int mid = (left + right) >> 1;

                    if(numbers.get(mid) < port) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                numbers.set(right, port);
            }
        }
    }

}