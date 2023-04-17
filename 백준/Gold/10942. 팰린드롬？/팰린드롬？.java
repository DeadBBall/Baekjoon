import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static int[] arr;
	static int m;
	static boolean[][] dp;
	static StringBuilder ansMaker;

	static void input() {
		n = sc.nextInt();
		arr = new int[n + 1];
		dp = new boolean[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		m = sc.nextInt();
		ansMaker = new StringBuilder();
	}

	static void ask() {
		for (int i = 0; i < m; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			if (dp[st][ed]) {
				ansMaker.append("1\n");
			} else {
				ansMaker.append("0\n");
			}
		}
	}

	static void setDp() {
		for (int i = 1; i <= n; i++) {
			dp[i][i] = true;
			if (arr[i] == arr[i - 1]) {
				dp[i - 1][i] = true;
			}
		}

		for (int i = 2; i < n; i++) {
			for (int j = 1; j <= n - i; j++) {
				if(dp[j + 1][j + i - 1] && arr[j] == arr[j + i]) {
					dp[j][j + i] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		input();
		setDp();
		ask();
		System.out.println(ansMaker);
	}
}