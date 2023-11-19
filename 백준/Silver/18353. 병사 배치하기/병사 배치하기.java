import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n, ans;
	static int[] soldiers;
	static int[] dp;
	
	public static void main(String[] args) {
		input();
		deploySoldiers();
		System.out.println(n - ans);
	}
	
	static void input() {
		n = sc.nextInt();
		dp = new int[n];
		soldiers = new int[n];
		
		for(int sIdx = 0; sIdx < n; sIdx++) {
			soldiers[sIdx] = sc.nextInt();
		}
	}
	
	static void deploySoldiers() {
		for(int first = 0; first < n; first++) {
			dp[first] = 1;
			for(int second = 0; second < first; second++) {
				if(soldiers[first] < soldiers[second])
					dp[first] = dp[second] + 1 > dp[first] ? dp[second] + 1 : dp[first];
			}
			ans = Math.max(ans, dp[first]);
		}
	}
}