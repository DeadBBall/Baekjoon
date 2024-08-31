import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static long n;
    static int p, q;
    static Map<Long, Long> progression;

    public static void main(String[] args) {
        input();
        System.out.println(findNumber(n));
    }

    static void input() {
        n = sc.nextLong();
        p = sc.nextInt();
        q = sc.nextInt();
        progression = new HashMap<>();
        progression.put(0L, 1L);
    }

    static long findNumber(long now) {
        if(progression.containsKey(now)) return progression.get(now);

        progression.put(now, findNumber(now / p) + findNumber(now / q));

        return progression.get(now);
    }

}