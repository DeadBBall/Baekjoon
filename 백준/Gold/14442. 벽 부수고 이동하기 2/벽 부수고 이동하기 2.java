import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static final int[] DY = {1, -1, 0, 0};
	static final int[] DX = {0, 0, 1, -1};
	static final int EMPTY = 0;
	static final int WALL = 1;
	static int n, m, k, ans;
	static int[][] board;
	static boolean[][][] visit;

	public static void main(String[] args) {
		input();
		smashWallAndMove();
		System.out.println(ans);
	}

	static void input() {
		n = SC.nextInt();
		m = SC.nextInt();
		k = SC.nextInt();
		ans = -1;

		board = new int[n][m];
		visit = new boolean[k + 1][n][m];
		for(int y = 0; y < n; y++) {
			String inputBoard = SC.next();
			for(int x = 0; x < m; x++) {
				board[y][x] = inputBoard.charAt(x) - '0';
			}
		}
	}
	
	static void smashWallAndMove() {
		Queue<Position> positionQueue = new LinkedList<>();
		
		positionQueue.add(new Position(0, 0, 1, 0));
		visit[0][0][0] = true;
		
		while(!positionQueue.isEmpty()) {
			Position now = positionQueue.remove();
			
			if(now.y == n - 1 && now.x == m - 1) {
				ans = now.moveCount;
				return;
			}
			
			for(int drct = 0; drct < 4; drct++) {
				int ny = now.y + DY[drct];
				int nx = now.x + DX[drct];
				
				if(!canMove(ny, nx)) continue;
				
				if(board[ny][nx] == EMPTY && !visit[now.removalCount][ny][nx]) {
					visit[now.removalCount][ny][nx] = true;
					positionQueue.add(new Position(ny, nx, now.moveCount + 1, now.removalCount));
				}
				else if(board[ny][nx] == WALL && now.removalCount + 1 <= k && !visit[now.removalCount + 1][ny][nx]) {
					visit[now.removalCount + 1][ny][nx] = true;
					positionQueue.add(new Position(ny, nx, now.moveCount + 1, now.removalCount + 1));
				}
				
			}
			
		}
		
	}
	
	static boolean canMove(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < m;
	}

}

class Position {
	int y;
	int x;
	int moveCount;
	int removalCount;
	
	public Position(int y, int x, int moveCount, int removalCount) {
		this.y = y;
		this.x = x;
		this.moveCount = moveCount;
		this.removalCount = removalCount;
	}
	
}