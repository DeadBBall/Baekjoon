import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int ans, n, k;
	static int[] nums;
	static int[] sums;
	
	static void input() {
		n = sc.nextInt();
		k = sc.nextInt();
		nums = new int[n + 1];
		sums = new int[n + 1];
		ans = -987654321;
		for(int i = 1; i <= n; i++) {
			nums[i] = sc.nextInt();
			sums[i] = sums[i - 1] + nums[i];
		}
	}
	
	static void checkTemp() {
		for(int i = k; i <= n; i++) {
			ans = Math.max(ans, sums[i] - sums[i - k]);
		}
	}
	
	public static void main(String[] args) {
		input();
		checkTemp();
		System.out.println(ans);
	}
}