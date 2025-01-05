import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, sum;
    static int[] nums;
    static long ans;

    public static void main(String[] args) {
        input();
        sum();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        nums = new int[n];

        for(int idx = 0; idx < n; idx++) {
            nums[idx] = sc.nextInt();
            sum += nums[idx];
        }
    }

    static void sum() {
        for(int idx = 0; idx < n; idx++) {
            ans += (long) nums[idx] * (sum - nums[idx]);
        }

        ans /= 2;
    }
}