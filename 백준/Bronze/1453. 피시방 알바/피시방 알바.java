import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static Set<Integer> numbers;

    public static void main(String[] args) {
        input();
        work();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        numbers = new HashSet<>();
    }

    static void work() {
        while(n-- > 0) {
            int guest = sc.nextInt();

            if (!numbers.add(guest)) {
                ans++;
            }
        }
    }
}