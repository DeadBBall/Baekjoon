import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static final int[] dy = { 1, -1, 0, 0 };
	static final int[] dx = { 0, 0, 1, -1 };
	static final char WALL = '1';
	static final char EMPTY = '0';
	static final int INF = 222;
	static int n, m;
	static char[][] board;
	static boolean[][][] visit;
	static int maxBrokenWall;
	static Point start;
	static Point end;
	
	
	public static void main(String[] args) {
		input();
		escapeMaze(start, 0);
		System.out.println(maxBrokenWall);
	}

	static void input() {
		m = sc.nextInt();
		n = sc.nextInt();
		board = new char[n][m];
		visit = new boolean[n][m][INF];
		
		for(int y = 0; y < n; y++) {
			String inputBoard = sc.next();
			
			board[y] = inputBoard.toCharArray();
		}
		
		start = new Point(0, 0);
		end = new Point(n - 1, m - 1);
		
		visit[0][0][0] = true;
		maxBrokenWall = INF;
	}

	static void escapeMaze(Point now, int brokenWall) {
		if(brokenWall + 1 == INF) return;
		
		if(now.y == end.y && now.x == end.x) {
			maxBrokenWall = Math.min(maxBrokenWall, brokenWall);
			return;
		}
		
		for(int drct = 0; drct < 4; drct++) {
			int ny = now.y + dy[drct];
			int nx = now.x + dx[drct];
			
			if(!canMove(ny, nx)) continue;
			
			if(board[ny][nx] == WALL && !visit[ny][nx][brokenWall + 1]) {
				board[ny][nx] = EMPTY;
				visit[ny][nx][brokenWall + 1] = true;
				escapeMaze(new Point(ny, nx), brokenWall + 1);
				board[ny][nx] = WALL;
			}
			else if(board[ny][nx] == EMPTY && !visit[ny][nx][brokenWall]){
				visit[ny][nx][brokenWall] = true;
				escapeMaze(new Point(ny, nx), brokenWall);
			}
			
		}
	}
	
	static boolean canMove(int y, int x) {
		return !(y < 0 || x < 0 || y >= n || x >= m);
	}
	

	static class Point {
		int y;
		int x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}

}