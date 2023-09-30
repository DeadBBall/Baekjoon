import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static final int[] DY = { 1, 0, -1, 0 };
	static final int[] DX = { 0, 1, 0, -1 };
	static boolean[][] board;
	static int c, r;
	static int k;
	static int ansY;
	static int ansX;

	public static void main(String[] args) {
		input();
		assignSeat();
		if(ansY == 0)
			System.out.println(0);
		else
			System.out.println(ansX + " " + ansY);
	}

	static void input() {
		c = sc.nextInt();
		r = sc.nextInt();
		k = sc.nextInt();
		board = new boolean[r + 1][c + 1];
	}

	static void assignSeat() {
		if(k > r * c) return;
		int ny = ansY = 1;
		int nx = ansX = 1;
		int nowNumber = 1;
		board[ny][nx] = true;
		int drct = 0;
		while(nowNumber <= k) {
			nowNumber++;
			if(!canMove(ny + DY[drct], nx + DX[drct]))
				drct = (drct + 1) % 4;
			ny += DY[drct];
			nx += DX[drct];
			if(nowNumber == k) {
				ansY = ny;
				ansX = nx;
				return;
			}
			board[ny][nx] = true;
		}
	}
	
	static boolean canMove(int y, int x) {
		return y >= 1 && x >= 1 && y <= r && x <= c && !board[y][x];
	}
}