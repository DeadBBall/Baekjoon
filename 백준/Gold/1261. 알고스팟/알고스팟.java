import java.util.Comparator;
import java.util.PriorityQueue;
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
	static boolean[][] visit;
	static int maxBrokenWall;
	static Point start;
	static Point end;
	
	public static void main(String[] args) {
		input();
		escapeMaze();
		System.out.println(maxBrokenWall);
	}

	static void input() {
		m = sc.nextInt();
		n = sc.nextInt();
		board = new char[n][m];
		visit = new boolean[n][m];
		
		for(int y = 0; y < n; y++) {
			String inputBoard = sc.next();
			
			board[y] = inputBoard.toCharArray();
		}
		
		start = new Point(0, 0, 0);
		end = new Point(n - 1, m - 1, 0);
		
		visit[0][0] = true;
		maxBrokenWall = INF;
	}

	static void escapeMaze() {
		PriorityQueue<Point> pointPQ = new PriorityQueue<>(new Comparator<Point>() {
			@Override
			public int compare(Point a, Point b) {
				return a.brokenWallCount - b.brokenWallCount;
			}
		});
		
		pointPQ.add(start);
		
		while(!pointPQ.isEmpty()) {
			Point now = pointPQ.remove();
			
			if(now.y == end.y && now.x == end.x) {
				maxBrokenWall = now.brokenWallCount;
				return;
			}
			
			for(int drct = 0; drct < 4; drct++) {
				int ny = now.y + dy[drct];
				int nx = now.x + dx[drct];
				
				if(!canMove(ny, nx)) continue;
				
				visit[ny][nx] = true;
				
				if(board[ny][nx] == WALL)
					pointPQ.add(new Point(ny, nx, now.brokenWallCount + 1));
				else
					pointPQ.add(new Point(ny, nx, now.brokenWallCount));
			}
		}
		

	}
	
	static boolean canMove(int y, int x) {
		return !(y < 0 || x < 0 || y >= n || x >= m || visit[y][x]);
	}
	

	static class Point {
		int y;
		int x;
		int brokenWallCount;

		public Point(int y, int x, int brokenWallCount) {
			this.y = y;
			this.x = x;
			this.brokenWallCount = brokenWallCount;
		}

	}

}