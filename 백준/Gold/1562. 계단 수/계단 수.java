import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static long[][][] dp;
	static final int MOD = 1000000000;
	static long ans;

	static void input() {
		n = sc.nextInt();
		dp = new long[n + 1][10][1 << 10];
		for (int i = 1; i <= 9; i++) {
			dp[1][i][1 << i] = 1;
		}
	}

	static void searchNum() {
		for (int i = 2; i <= n; i++) {
			for (int k = 0; k <= 9; k++) {
				for (int j = 0; j < (1 << 10); j++) {
					int visit = j | (1 << k);
					if (k == 0) {
						dp[i][k][visit] += dp[i - 1][k + 1][j] % MOD;
					} else if (k == 9) {
						dp[i][k][visit] += dp[i - 1][k - 1][j] % MOD;
					} else {
						dp[i][k][visit] += dp[i - 1][k + 1][j] % MOD + dp[i - 1][k - 1][j] % MOD;
					}
					dp[i][k][visit] %= MOD;
				}
			}
		}
		for (int i = 0; i <= 9; i++) {
			ans += dp[n][i][(1 << 10) - 1] % MOD;
			ans %= MOD;
		}
	}
	public static void main(String[] args) {
		input();
		searchNum();
		System.out.println(ans);
	}
}