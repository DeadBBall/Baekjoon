import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static final char BUILDING = 'X';
	static final char EMPTY = '.';
	static final int[] DY = {-1, 0, 1};
	static int r, c, ans;
	static boolean finish;
	static char[][] board;
	static boolean[][] visit;

	public static void main(String[] args) {
		input();
		checkAll();
		System.out.println(ans);
	}

	static void input() {
		r = SC.nextInt();
		c = SC.nextInt();
		board = new char[r][c];
		visit = new boolean[r][c];

		for(int y = 0; y < r; y++) {
			String inputBoard = SC.next();
			for(int x = 0; x < c; x++) {
				board[y] = inputBoard.toCharArray();
			}
		}
	}
	
	static void checkAll() {
		for(int y = 0; y < r; y++) {
			finish = false;
			connectPipe(y, 0);
		}
	}
	
	static void connectPipe(int nowY, int nowX) {
		visit[nowY][nowX] = true;
		
		if(nowX == c - 1) {
			ans++;
			finish = true;
			return;
		}
		
		for(int drct = 0; drct < 3; drct++) {
			if(finish) return;
			int ny = nowY + DY[drct];
			int nx = nowX + 1;
			
			if(!canMove(ny, nx)) continue;
			
			connectPipe(ny, nx);
		}
	}
	
	static boolean canMove(int y, int x) {
		return y >= 0 && y < r && x >= 0 && x < c
				&& !visit[y][x] && board[y][x] == EMPTY;
	}
}

class Pipe {
	int y;
	int x;
	
	public Pipe(int y, int x) {
		this.y = y;
		this.x = x;
	}
	
}