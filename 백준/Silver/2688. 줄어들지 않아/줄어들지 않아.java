import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static long[][] dp;
	static StringBuilder ansMaker = new StringBuilder();
	
	public static void main(String[] args) {
		int t = SC.nextInt();
		countNumber();
		
		while(t-- > 0) {
			countN();
		}
		System.out.print(ansMaker);
	}

	static void countNumber() {
		dp = new long[65][10];
		
		for(int num = 0; num <= 9; num++) {
			dp[1][num] = 1;
		}
		
		for(int digit = 2; digit <= 64; digit++) {
			for(int last = 0; last <= 9; last++) {
				for(int num = 0; num <= last; num++) {
					dp[digit][last] += dp[digit - 1][num];
				}
			}
		}
		
	}
	
	static void countN() {
		int n = SC.nextInt();
		long number = 0;
		
		for(int last = 0; last <= 9; last++) {
			number += dp[n][last];
		}
		
		ansMaker.append(number + "\n");
	}

}