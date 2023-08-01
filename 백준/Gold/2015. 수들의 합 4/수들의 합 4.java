import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int[] sumArr;
    static Map<Integer, Integer> map;
    static int n;
    static int k;
    static long ans;

    public static void main(String[] args) {
        input();
        countNumEqualsK();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        k = sc.nextInt();

        sumArr = new int[n];
        map = new HashMap<>();

        int sum = 0;

        for(int idx = 0; idx < n; idx++) {
            sum += sc.nextInt();
            sumArr[idx] = sum;
        }

        map.put(0, 1);
    }

    static void countNumEqualsK() {
        for(int idx = 0; idx < n; idx++) {
            ans += map.getOrDefault(sumArr[idx] - k, 0);
            map.put(sumArr[idx], map.getOrDefault(sumArr[idx], 0) + 1);
        }
    }
}
