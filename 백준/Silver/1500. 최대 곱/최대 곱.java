import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int s, k;
    static long ans;

    public static void main(String[] args) {
        input();
        findMax();
        System.out.println(ans);
    }

    static void input() {
        s = sc.nextInt();
        k = sc.nextInt();
    }

    static void findMax() {
        if(s * k == 0) return;
        ans = 1;

        int[] nums = new int[k];
        Arrays.fill(nums, s / k);

        s %= k;

        for(int idx = 0; idx < k; idx++) {
            if(s != 0){
                s--;
                nums[idx]++;
            }

            ans *= nums[idx];
        }

    }
}