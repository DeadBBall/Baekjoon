import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static final char BEAVER = 'D';
	static final char HEDGEHOG = 'S';
	static final char EMPTY = '.';
	static final char WATER = '*';
	static final char WALL = 'X';
	static final String FAIL = "KAKTUS";
	static final int[] dy = { 1, -1, 0, 0 };
	static final int[] dx = { 0, 0, 1, -1 };
	static int r, c;
	static char[][] board;
	static boolean ans;
	static int time;
	static Queue<Point> waterQueue;
	static Queue<Point> hedgehogQueue;

	public static void main(String[] args) {
		input();
		escape();
//		for(int y = 0; y < r; y++) {
//			for(int x = 0; x < c; x++) {
//				System.out.print(board[y][x]);
//			}
//			System.out.println();
//		}
		System.out.println(ans ? time : FAIL);
	}

	static void input() {
		r = sc.nextInt();
		c = sc.nextInt();
		board = new char[r][c];
		waterQueue = new LinkedList<>();
		hedgehogQueue = new LinkedList<>();

		for (int y = 0; y < r; y++) {
			String inputStr = sc.next();
			board[y] = inputStr.toCharArray();

			for (int x = 0; x < c; x++) {
				if (board[y][x] == HEDGEHOG)
					hedgehogQueue.add(new Point(y, x));
				else if(board[y][x] == WATER)
					waterQueue.add(new Point(y, x));
			}
		}
	}

	static void escape() {
		while(!hedgehogQueue.isEmpty()) {
			moveWater();
			moveHedgehog();
			time++;
		}
	}
	
	static void moveWater() {
		int size = waterQueue.size();
		
		while(size-- > 0) {
			Point now = waterQueue.remove();
			
			for(int drct = 0; drct < 4; drct++) {
				int ny = now.y + dy[drct];
				int nx = now.x + dx[drct];
				
				if(!canMove(ny, nx)) continue;
				
				if(board[ny][nx] != EMPTY) continue;
				
				board[ny][nx] = WATER;
				
				waterQueue.add(new Point(ny, nx));
			}
		}
	}
	
	static boolean canMove(int y, int x) {
		return !(y < 0 || x < 0 || y >= r || x >= c);
	}
	
	static void moveHedgehog() {
		int size = hedgehogQueue.size();
		
		while(size-- > 0) {
			Point now = hedgehogQueue.remove();
			
			for(int drct = 0; drct < 4; drct++) {
				int ny = now.y + dy[drct];
				int nx = now.x + dx[drct];
				
				if(!canMove(ny, nx)) continue;
				
				if(board[ny][nx] == BEAVER) {
					ans = true;
					hedgehogQueue.clear();
					return;
				}
				
				if(board[ny][nx] != EMPTY) continue;
				
				board[ny][nx] = HEDGEHOG;
				
				hedgehogQueue.add(new Point(ny, nx));
			}
			
		}
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