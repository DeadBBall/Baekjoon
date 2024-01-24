import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static final int START = 1;
	static int t, w, ans;
	static int[][] dp;
	static int[] plums;
	
	public static void main(String[] args) {
		input();
		getPlum();
		System.out.println(ans);
	}
	
	static void input() {
		t = SC.nextInt();
		w = SC.nextInt();
		dp = new int[t + 1][w + 1];
		plums = new int[t + 1];
		
		for(int plumIdx = 1; plumIdx <= t; plumIdx++) {
			plums[plumIdx] = SC.nextInt();
		}
	}
	
	static void getPlum() {
		for(int time = 1; time <= t; time++) {
			
			for(int move = 0; move <= w; move++) {
				
				if(move == 0) {
					if(plums[time] == START) {
						dp[time][move] = dp[time - 1][move] + 1;
					}
					else {
						dp[time][move] = dp[time - 1][move];
					}
					continue;
				}
				
				if(move % 2 == 0) {
					if(plums[time] == START) {
						dp[time][move] = Math.max(dp[time - 1][move] + 1, dp[time - 1][move - 1]);
					}
					else {
						dp[time][move] = Math.max(dp[time - 1][move], dp[time - 1][move - 1] + 1);
					}
				}
				
				else {
					if(plums[time] != START) {
						dp[time][move] = Math.max(dp[time - 1][move] + 1, dp[time - 1][move - 1]);
					}
					else {
						dp[time][move] = Math.max(dp[time - 1][move], dp[time - 1][move - 1] + 1);
					}
				}
				
				ans = Math.max(ans, dp[time][move]);
			}
		}
	}
	
}