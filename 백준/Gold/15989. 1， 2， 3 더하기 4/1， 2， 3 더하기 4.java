import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static StringBuilder ansMaker = new StringBuilder();
	static int[][] dp = new int[10001][4];
	static int n;
	
	public static void main(String[] args) {
		int t = SC.nextInt();
		makeNumber();
		
		while(t-- > 0) {
			n = SC.nextInt();
			ansMaker.append(dp[n][1] + dp[n][2] + dp[n][3] + "\n");
		}
		
		System.out.print(ansMaker);
	}

	static void makeNumber() {
		dp[1][1] = 1;
		dp[2][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;
		
		
		for(int num = 4; num <= 10000; num++) {
			dp[num][1] = dp[num - 1][1];
			dp[num][2] = dp[num - 2][1] + dp[num - 2][2];
			dp[num][3] = dp[num - 3][1] + dp[num - 3][2] + dp[num - 3][3];
		}
	}
	
}