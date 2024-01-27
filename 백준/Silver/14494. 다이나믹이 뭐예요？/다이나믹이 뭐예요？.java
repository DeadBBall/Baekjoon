import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static final int MOD = 1000000007;
	static int n, m;
	static long[][] dp;

	public static void main(String[] args) {
		input();
		countCase();
		System.out.println(dp[n][m]);
	}

	static void input() {
		n = SC.nextInt();
		m = SC.nextInt();
		dp = new long[n + 1][m + 1];
	}

	static void countCase() {
		dp[0][0] = 1;
		
		for(int y = 1; y <= n; y++) {
			for(int x = 1; x <= m; x++) {
				dp[y][x] = (dp[y - 1][x] + dp[y][x - 1] + dp[y - 1][x - 1]) % MOD;
			}
		}
	}

}