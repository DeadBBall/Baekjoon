import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static final int[] DY = {0, 1, -1, 0, 0 };
	static final int[] DX = {0, 0, 0, 1, -1 };
	static int n, ans;
	static int[][] board;
	static boolean[][] visit;

	public static void main(String[] args) {
		input();
		plantFlowers(1, 0, 0);
		System.out.println(ans);
	}

	static void input() {
		n = SC.nextInt();
		board = new int[n][n];
		visit = new boolean[n][n];
		ans = Integer.MAX_VALUE;

		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				board[y][x] = SC.nextInt();
			}
		}
	}

	static void plantFlowers(int nowY, int flower, int cost) {
		if(flower == 3) {
			ans = Math.min(ans, cost);
			return;
		}
		
		for(int y = nowY; y < n - 1; y++) {
			for(int x = 1; x < n - 1; x++) {
				boolean canPlant = true;
				
				for(int drct = 0; drct < 5; drct++) {
					int ny = y + DY[drct];
					int nx = x + DX[drct];
					
					if(visit[ny][nx]) {
						canPlant = false;
						break;
					}
				}
				
				if(!canPlant) continue;
				
				int additionalCost = 0;
				
				for(int drct = 0; drct < 5; drct++) {
					int ny = y + DY[drct];
					int nx = x + DX[drct];
					
					visit[ny][nx] = true;
					additionalCost += board[ny][nx];
				}
				
				plantFlowers(y, flower + 1, cost + additionalCost);
				
				for(int drct = 0; drct < 5; drct++) {
					int ny = y + DY[drct];
					int nx = x + DX[drct];
					
					visit[ny][nx] = false;
				}
			}
		}
		
	}
}