import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static int[] costs;
	static int[] dp;
	static int ans;
	static final int INF = 1000001;
	
	static void input() {
		n = sc.nextInt();
		costs = new int[n + 1];
		dp = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			costs[i] = sc.nextInt();
			dp[i] = INF;
		}
	}
	
	static void buyCard() {
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= i; j++) {
				dp[i] = Math.min(dp[i - j] + costs[j], dp[i]);
			}
		}
		ans = dp[n];
	}
	
	public static void main(String[] args) {
		input();
		buyCard();
		System.out.println(ans);
	}
}