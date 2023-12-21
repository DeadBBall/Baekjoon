import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static final int INF = 987654321;
	static int n, ans;
	static int[][] costs;
	static int[][] dp;

	public static void main(String[] args) {
		input();
		paintHouse();
		System.out.println(ans);
	}

	static void input() {
		n = SC.nextInt();
		costs = new int[n][3];
		dp = new int[n][3];

		for (int lineIdx = 0; lineIdx < n; lineIdx++) {
			for (int houseIdx = 0; houseIdx < 3; houseIdx++) {
				costs[lineIdx][houseIdx] = SC.nextInt();
			}
		}
	}

	static void paintHouse() {
		dp[0][0] = costs[0][0];
		dp[0][1] = dp[0][2] = INF;
		
		for(int lineIdx = 1; lineIdx < n; lineIdx++) {
			dp[lineIdx][0] = Math.min(dp[lineIdx - 1][1], dp[lineIdx - 1][2]) + costs[lineIdx][0];
			dp[lineIdx][1] = Math.min(dp[lineIdx - 1][0], dp[lineIdx - 1][2]) + costs[lineIdx][1];
			dp[lineIdx][2] = Math.min(dp[lineIdx - 1][1], dp[lineIdx - 1][0]) + costs[lineIdx][2];
		}
		
		ans = Math.min(dp[n - 1][1], dp[n - 1][2]);
		
		dp[0][1] = costs[0][1];
		dp[0][0] = dp[0][2] = INF;
		
		for(int lineIdx = 1; lineIdx < n; lineIdx++) {
			dp[lineIdx][0] = Math.min(dp[lineIdx - 1][1], dp[lineIdx - 1][2]) + costs[lineIdx][0];
			dp[lineIdx][1] = Math.min(dp[lineIdx - 1][0], dp[lineIdx - 1][2]) + costs[lineIdx][1];
			dp[lineIdx][2] = Math.min(dp[lineIdx - 1][1], dp[lineIdx - 1][0]) + costs[lineIdx][2];
		}
		
		ans = Math.min(ans, dp[n - 1][0]);
		ans = Math.min(ans, dp[n - 1][2]);
		
		dp[0][2] = costs[0][2];
		dp[0][1] = dp[0][0] = INF;
		
		for(int lineIdx = 1; lineIdx < n; lineIdx++) {
			dp[lineIdx][0] = Math.min(dp[lineIdx - 1][1], dp[lineIdx - 1][2]) + costs[lineIdx][0];
			dp[lineIdx][1] = Math.min(dp[lineIdx - 1][0], dp[lineIdx - 1][2]) + costs[lineIdx][1];
			dp[lineIdx][2] = Math.min(dp[lineIdx - 1][1], dp[lineIdx - 1][0]) + costs[lineIdx][2];
		}
		
		ans = Math.min(ans, dp[n - 1][0]);
		ans = Math.min(ans, dp[n - 1][1]);
	}

}