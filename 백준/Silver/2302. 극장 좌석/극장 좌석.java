import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static int[] dp;
	static int vipCnt;
	static int[] vip;
	static int ans;
	
	static void input() {
		n = sc.nextInt();
		dp = new int[41];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		vipCnt = sc.nextInt();
		vip = new int[vipCnt];
		for(int i = 0; i < vipCnt; i++) {
			vip[i] = sc.nextInt();
		}
		ans = 1;
	}
	
	static void countNum() {
		int prev = 0;
		for(int i = 0; i < vipCnt; i++) {
			ans *= dp[vip[i] - prev - 1];
			prev = vip[i];
		}
		ans *= dp[n - prev];
	}
	
	public static void main(String[] args) {
		input();
		countNum();
		System.out.println(ans);
	}
}