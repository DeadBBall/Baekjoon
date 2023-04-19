import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static int[] arr;
	static long[][] dp;

	static void input() {
		n = sc.nextInt();
		arr = new int[n];
		dp = new long[n][21];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		dp[0][arr[0]] = 1;
	}

	static void calc() {
		for (int j = 1; j < n - 1; j++) {
			for (int i = 0; i <= 20; i++) {
				if (dp[j - 1][i] != 0) {
					int plus = i + arr[j];
					int minus = i - arr[j];
					if (plus <= 20) {
						dp[j][plus] += dp[j - 1][i];
					}
					if (0 <= minus) {
						dp[j][minus] += dp[j - 1][i];
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		input();
		calc();
		System.out.println(dp[n - 2][arr[n - 1]]);
	}
}