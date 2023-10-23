import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int[] nums;
    static int[] upDP;
    static int[] downDP;
    static int ans;

    public static void main(String[] args) {
        input();
        searchMaxSection();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        upDP = new int[n + 1];
        downDP = new int[n + 1];
        nums = new int[n];
        ans = 1;

        for(int idx = 0; idx < n; idx++) {
            nums[idx] = sc.nextInt();
            upDP[idx] = 1;
            downDP[idx] = 1;
        }
    }

    static void searchMaxSection() {
        for(int idx = 1; idx < n; idx++) {
            if(nums[idx - 1] <= nums[idx]) {
                upDP[idx] = upDP[idx - 1] + 1;
            }
            if(nums[idx - 1] >= nums[idx]) {
                downDP[idx] = downDP[idx - 1] + 1;
            }
            ans = Math.max(Math.max(upDP[idx], ans), downDP[idx]);
        }
    }
}