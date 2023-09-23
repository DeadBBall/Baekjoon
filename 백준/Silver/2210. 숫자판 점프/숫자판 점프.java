import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static final int BOARDSIZE = 5;
	static final int MAXLENGTH = 6;
	static final int[] DY = {1, -1, 0, 0};
	static final int[] DX = {0, 0, 1, -1};
	static int[][] board = new int[BOARDSIZE][BOARDSIZE];
	static Set<String> numberSet;
	
	
	public static void main(String[] args) {
		input();
		doBruteForce();
		System.out.println(numberSet.size());
	}

	
	static void input() {
		for(int y = 0; y < BOARDSIZE; y++) {
			for(int x = 0; x < BOARDSIZE; x++) {
				board[y][x] = sc.nextInt();
			}
		}
		
		numberSet = new HashSet<>();
	}
	
	static void doBruteForce() {
		StringBuilder numberMaker = new StringBuilder();
		for(int y = 0; y < BOARDSIZE; y++) {
			for(int x = 0; x < BOARDSIZE; x++) {
				numberMaker.setLength(0);
				numberMaker.append(board[y][x]);
				makeNumber(numberMaker, y, x);
			}
		}
	}
	
	static void makeNumber(StringBuilder number, int y, int x) {
		if(number.length() == MAXLENGTH) {
			numberSet.add(number.toString());
			return;
		}
		
		for(int drct = 0; drct < 4; drct++) {
			int ny = y + DY[drct];
			int nx = x + DX[drct];
			
			if(!canMove(ny, nx)) continue;
			
			number.append(board[ny][nx]);
			makeNumber(number, ny, nx);
			number.deleteCharAt(number.length() - 1);
		}
		
	}
	
	static boolean canMove(int y, int x) {
		return y >= 0 && x >= 0 && y < BOARDSIZE && x < BOARDSIZE;
	}
	
}