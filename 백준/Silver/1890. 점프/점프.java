import java.util.Scanner;

public class Main {
	static int n;
	static int[][] map;
	static int[] dy = {1, 0};
	static int[] dx = {0, 1};
	static long[][] dp;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		dp = new long[n][n];
		for(int y = 0; y < n; y++) {
			for(int x = 0; x < n; x++) {
				map[y][x] = sc.nextInt();
				dp[y][x] = -1;
			}
		}
	}
	
	static long jump(int y, int x) {
		if(y == n - 1 && x == n - 1) {
			return 1;
		}
		else if(dp[y][x] != -1) {
			return dp[y][x];
		}
		dp[y][x] = 0;	
		for(int i = 0; i < 2; i++) {
			int ny = y + dy[i] * map[y][x];
			int nx = x + dx[i] * map[y][x];
			if(ny >= n || nx >= n) {
				continue;
			}
			dp[y][x] += jump(ny, nx);
		}
		return dp[y][x];
	}
	
	static void solve() {
		input();
		System.out.println(jump(0 ,0));
	}
	
	public static void main(String[] args) {
		solve();
	}
}