import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static final int[][] DATT = {{-9, -3, -1}, {-9, -1, -3}, {-3, -9, -1}, {-3, -1, -9}, {-1, -9, -3}, {-1, -3, -9}};
	static int n, ans;
	static int[] scvs;
	static int[][][] dp;
	
	public static void main(String[] args) {
		input();
		killSCV(scvs, 0);
		System.out.println(ans);
	}
	
	static void input() {
		n = SC.nextInt();
		scvs = new int[3];
		ans = Integer.MAX_VALUE;
		
		for(int scvIdx = 0; scvIdx < n; scvIdx++) {
			scvs[scvIdx] = SC.nextInt();
		}
		
		dp = new int[scvs[0] + 1][scvs[1] + 1][scvs[2] + 1];
	}
	
	static void killSCV(int[] scv, int attCnt) {
		if(ans <= attCnt) return;
		
		if(dp[scv[0]][scv[1]][scv[2]] != 0 && dp[scv[0]][scv[1]][scv[2]] <= attCnt) return;
		
		dp[scv[0]][scv[1]][scv[2]] = attCnt;
		
		if(scv[0] == 0 && scv[1] == 0 && scv[2] == 0) {
			ans = Math.min(ans, attCnt);
			return;
		}
		
		for(int dlt = 0; dlt < 6; dlt++) {
			int s1 = Math.max(scv[0] + DATT[dlt][0], 0);
			int s2 = Math.max(scv[1] + DATT[dlt][1], 0);
			int s3 = Math.max(scv[2] + DATT[dlt][2], 0);
			
			killSCV(new int[] {s1, s2, s3}, attCnt + 1);
		}
		
	}
}