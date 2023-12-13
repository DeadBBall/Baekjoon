import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static final int[] DY = {1, -1, 0, 0};
	static final int[] DX = {0, 0, 1, -1};
	static final char LAND = 'X';
	static final char SEA = '.';
	static int r, c;
	static char[][] board;
	static StringBuilder ansMaker;

	public static void main(String[] args){
		input();
		drawMap();
		System.out.println(ansMaker);
	}

	static void input() {
		r = SC.nextInt();
		c = SC.nextInt();
		board = new char[r][c];
		ansMaker = new StringBuilder();
		
		for(int y = 0; y < r; y++) {
			String inputBoard = SC.next();
			board[y] = inputBoard.toCharArray();
		}
	}

	static void drawMap() {
		char[][] newBoard = new char[r][c];
		List<int[]> lands = new ArrayList<>();
		
		for(int y = 0; y < r; y++) {
			for(int x = 0; x < c; x++) {
				newBoard[y][x] = board[y][x];
			}
		}
		
		for(int y = 0; y < r; y++) {
			for(int x = 0; x < c; x++) {
				if(board[y][x] == SEA) continue;
				int seaCount = 0;
				for(int drct = 0; drct < 4; drct++) {
					int ny = y + DY[drct];
					int nx = x + DX[drct];
					
					if(!canMove(ny, nx)) seaCount++;
					else if(board[ny][nx] == SEA) seaCount++;
				}
				if(seaCount >= 3)
					newBoard[y][x] = SEA;
				else
					lands.add(new int[] {y, x});
			}
		}
		int lowY = r - 1;
		int lowX = c - 1;
		int highY = 0;
		int highX = 0;
		
		for(int[] land : lands) {
			lowY = Math.min(land[0], lowY);
			lowX = Math.min(land[1], lowX);
			highY = Math.max(land[0], highY);
			highX = Math.max(land[1], highX);
		}
		
		for(int y = lowY; y <= highY; y++) {
			for(int x = lowX; x <= highX; x++) {
				ansMaker.append(newBoard[y][x]);
			}
			ansMaker.append("\n");
		}
		
	}
	
	static boolean canMove(int y, int x) {
		return y >= 0 && y < r && x >= 0 && x < c;
	}

}