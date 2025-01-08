import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static int[] nums;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        trade();
        System.out.print(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();

        nums = new int[n + 1];

        for(int idx = 1; idx <= n; idx++) {
            nums[idx] = idx;
        }

        ansMaker = new StringBuilder();
    }

    static void trade() {
        while(m-- > 0) {
            int left = sc.nextInt();
            int right = sc.nextInt();

            swap(left, right);
        }

        for(int idx = 1; idx <= n; idx++) {
            ansMaker.append(nums[idx]).append(" ");
        }
    }

    static void swap(int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}