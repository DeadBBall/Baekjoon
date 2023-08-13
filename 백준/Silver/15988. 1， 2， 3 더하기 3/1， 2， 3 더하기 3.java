import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static final int MOD = 1000000009;
	static int n;
	static long[] dp = new long[1000001];
	
	public static void main(String[] args) {
		int t = sc.nextInt();
		makeDp();
		for(int idx = 0; idx < t; idx++) {
			System.out.println(dp[sc.nextInt()]);
		}
	}

	static void makeDp() {
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int idx = 4; idx <= 1000000; idx++) {
			dp[idx] = (dp[idx - 1] + dp[idx - 2] + dp[idx - 3]) % MOD;
		}
		
	}
	
}