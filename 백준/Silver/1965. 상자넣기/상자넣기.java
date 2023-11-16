import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static int[] nums;
	static int[] dp;
	static int ans;
	
	static void input() {
		n = sc.nextInt();
		nums = new int[n];
		dp = new int[n];
		for(int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
			dp[i] = 1;
		}
	}
	
	static void putBox() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
				ans = Math.max(ans, dp[i]);
			}
		}
	}
	
	public static void main(String[] args) {
		input();
		putBox();
		System.out.println(ans);
	}
}