import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static String str;
	static int dp[][];
	static final int MOD = 1000000;
	static int ans;
	static int len;
	
	static void input() { // 입력 메소드
		str = sc.next();
		len = str.length();
		dp = new int[len + 1][2];
		if(str.charAt(0) != '0') {
			dp[0][0] = 1;
			dp[1][0] = 1;
		}
	}

	static void interpretPwd() {
		for(int i = 2; i <= len; i++ ) {
			if(str.charAt(i - 1) != '0') {
				dp[i][0] = (dp[i - 1][1] + dp[i - 1][0]) % MOD;
				if(str.charAt(i - 2) == '0') {
					continue;
				}
				int num = Integer.parseInt(str.substring(i - 2, i));
				if(num <= 26) {
					dp[i][1] = (dp[i - 2][1] + dp[i - 2][0]) % MOD;
				}
			}
			else {
				if(str.charAt(i - 2) == '0') {
					continue;
				}
				int num = Integer.parseInt(str.substring(i - 2, i));
				if(num <= 26) {
					dp[i][1] = (dp[i - 2][1] + dp[i - 2][0]) % MOD;
				}
			}
		}
		ans = (dp[len][1] + dp[len][0]) % MOD;
	}
	
	public static void main(String[] args) {
		input();
		interpretPwd();
		System.out.println(ans);
	}
}