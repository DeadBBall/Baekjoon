import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static String s;
	static String t;
	static int[][] dp;
	static int ans;
	
	static void input() {
		s = sc.next();
		t = sc.next();
		dp = new int[s.length() + 1][t.length() + 1];		
	}
	
	static void searchStr() {
		for(int i = 0; i < s.length(); i++) {
			for(int j = 0; j < t.length(); j++) {
				if(s.charAt(i) == t.charAt(j)) {
					dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + 1);
				}
				ans = Math.max(dp[i + 1][j + 1], ans);
			}
		}
	}
	
	public static void main(String[] args) {
		input();
		searchStr();
		System.out.println(ans);
	}
}