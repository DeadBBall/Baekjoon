import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static final int MOD = 1000000009;
	static int n;
	static long[][] dp = new long[100001][4];
	static StringBuilder ansMaker = new StringBuilder();
	
	public static void main(String[] args) {
		int t = sc.nextInt();
		makeNumber();
		while(t-- > 0) {
			input();
			searchAns();
		}
		System.out.println(ansMaker);
	}
	
	static void makeNumber() {
		dp[1][1] = 1;
		dp[2][2] = 1;
		for(int idx = 1; idx <= 3; idx++) {
			dp[3][idx] = 1;
		}
		
		for(int num = 4; num <= 100000; num++) {
			dp[num][1] = (dp[num - 1][2] + dp[num - 1][3]) % MOD;
			dp[num][2] = (dp[num - 2][1] + dp[num - 2][3]) % MOD;
			dp[num][3] = (dp[num - 3][1] + dp[num - 3][2]) % MOD;
		}
	}
	
	static void input() {
		n = sc.nextInt();
	}
	
	static void searchAns() {
		ansMaker.append((dp[n][1] + dp[n][2] + dp[n][3]) % MOD).append("\n");
	}

}
