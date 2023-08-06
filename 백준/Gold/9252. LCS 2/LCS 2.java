import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int[][] dp = new int[1001][1001];
	static String a;
	static String b;
	
	
	public static void main(String[] args) {
		input();
		searchLCS();
		printAns();
	}

	static void input() {
		a = sc.next();
		b = sc.next();
	}

	static void searchLCS() {
		for(int aIdx = 0; aIdx < a.length(); aIdx++) {
			
			for(int bIdx = 0; bIdx < b.length(); bIdx++) {
				
				if(a.charAt(aIdx) == b.charAt(bIdx)) {
					dp[aIdx + 1][bIdx + 1] = dp[aIdx][bIdx] + 1;
				} else {
					dp[aIdx + 1][bIdx + 1] = Math.max(dp[aIdx + 1][bIdx], dp[aIdx][bIdx + 1]);
				}
				
			}
		}
	}
	
	static void printAns() {
		StringBuilder ans = new StringBuilder();
		int aIdx = a.length() - 1;
		int bIdx = b.length() - 1;
		
		while(aIdx >= 0 && bIdx >= 0) {
			
			if(a.charAt(aIdx) == b.charAt(bIdx)) {
				ans.append(a.charAt(aIdx));
				
				aIdx--;
				bIdx--;
			} else {
				
				if(dp[aIdx + 1][bIdx] == dp[aIdx + 1][bIdx + 1]) bIdx--;
				
				else aIdx--; 
			}
			
		}
		
		System.out.println(dp[a.length()][b.length()]);
		
		if(ans.length() != 0) System.out.println(ans.reverse().toString());
	}
	
}
