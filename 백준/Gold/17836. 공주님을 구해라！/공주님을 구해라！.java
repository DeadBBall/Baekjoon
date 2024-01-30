import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static final int EMPTY = 0;
	static final int WALL = 1;
	static final int GRAM = 2;
	static final int[] DY = {1, -1, 0, 0};
	static final int[] DX = {0, 0, 1, -1};
	static int n, m, t, ans;
	static int[][] board;
	static boolean[][] visit;
	
	public static void main(String[] args) {
		input();
		savePrincess();
		System.out.println(ans == Integer.MAX_VALUE ? "Fail" : ans);
	}

	static void input() {
		n = SC.nextInt();
		m = SC.nextInt();
		t = SC.nextInt();
		
		board = new int[n][m];
		visit = new boolean[n][m];
		ans = Integer.MAX_VALUE;
		
		for(int y = 0; y < n; y++) {
			for(int x = 0; x < m; x++) {
				board[y][x] = SC.nextInt();
			}
		}
		
	}
	
	static void savePrincess() {
		Queue<Soldier> soldierQueue = new LinkedList<>();
		soldierQueue.add(new Soldier(0, 0, 0));
		visit[0][0] = true;
		
		while(!soldierQueue.isEmpty()) {
			Soldier now = soldierQueue.remove();
			
			if(board[now.y][now.x] == GRAM) {
				int dist = now.dist + n - 1 - now.y + m - 1 - now.x;
				
				if(dist <= t)
					ans = Math.min(dist, ans);
				
				continue;
			}
			
			if(now.y == n - 1 && now.x == m - 1) {
				ans = Math.min(now.dist, ans);
				return;
			}
			
			if(now.dist == t) continue;
			
			for(int drct = 0; drct < 4; drct++) {
				int ny = now.y + DY[drct];
				int nx = now.x + DX[drct];
				
				if(!canMove(ny, nx)) continue;
				
				visit[ny][nx] = true;
				
				soldierQueue.add(new Soldier(ny, nx, now.dist + 1));
			}
			
		}
		
	}
	
	static boolean canMove(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < m && board[y][x] != WALL && !visit[y][x];
	}
	
}

class Soldier {
	int y;
	int x;
	int dist;
	
	public Soldier(int y, int x, int dist) {
		this.y = y;
		this.x = x;
		this.dist = dist;
	}
}