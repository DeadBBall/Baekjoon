import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int k;
    static int[][] dp;
	
	public static void main(String[] args) {
		k = sc.nextInt();
		dp = new int[k + 1][2];
		dp[1][0] = 0;
		dp[1][1] = 1;
		for(int i = 2; i <= k; i++) {
			dp[i][0] = dp[i - 1][1];
			dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
		}
		System.out.println(dp[k][0] + " " + dp[k][1]);
	}
}