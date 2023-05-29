import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int ans;
	static int[] files;
	static int n;
	static int[] sum;
	static int[][] dp;
	
	static void input() {
		ans = 0;
		n = sc.nextInt();
		files = new int[n + 1];
		sum = new int[n + 1];
		dp = new int[n + 1][n + 1];
		for(int i = 1; i <= n; i++) {
			files[i] = sc.nextInt();
			sum[i] = sum[i - 1] + files[i];
		}
	}
	
	static void uniteFile() {
		for(int i = 1; i <= n; i++) {
			for(int s = 1; s + i <= n; s++) {
				int e = s + i;
				dp[s][e] = Integer.MAX_VALUE;
				for(int d = s; d < e; d++) {
					 dp[s][e] = Math.min(dp[s][e], dp[s][d] + dp[d + 1][e] + sum[e] - sum[s - 1]);
				}
			}
		}
		ans = dp[1][n];
	}
	
	public static void main(String[] args) {
		int t;
		t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			input();
			uniteFile();
			System.out.println(ans);
		}
	}
}