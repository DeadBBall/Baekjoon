import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static long[] dp;
	
	public static void main(String[] args) {
		n = sc.nextInt();
		dp = new long[n + 1];
		dp[0] = 2;
		dp[1] = 4;
		for(int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		System.out.println(dp[n]);
	}
}