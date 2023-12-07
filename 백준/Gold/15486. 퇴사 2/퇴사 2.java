import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static Counseling[] counselings;
	static int[] dp;
	
	public static void main(String[] args) {
		input();
		consult();
		System.out.println(dp[n]);
	}	
	
	static void input() {
		n = sc.nextInt();
		counselings = new Counseling[n];
		dp = new int[n + 1];
		
		for(int counselingIdx = 0; counselingIdx < n; counselingIdx++) {
			int period = sc.nextInt();
			int profit = sc.nextInt();
			counselings[counselingIdx] = new Counseling(period, profit);
		}
	}
	
	static void consult() {
		for(int day = 0; day < n; day++) {
			
			if(day + counselings[day].period <= n)
				dp[day + counselings[day].period] = Math.max(dp[day + counselings[day].period], dp[day] + counselings[day].profit);
			
			dp[day + 1] = Math.max(dp[day + 1], dp[day]);
		}
	}
	
}

class Counseling {
	int period;
	int profit;
	
	public Counseling(int period, int profit) {
		this.period = period;
		this.profit = profit;
	}
	
}