import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int[][] board;
	static StringBuilder ansMaker;
	static boolean getAnswer;
	
	public static void main(String[] args) {
		input();
		playSudoku(0, 0);
	}
	
	static void input() {
		board = new int[9][9];
		ansMaker = new StringBuilder();
		
		for(int y = 0; y < 9; y++) {
			for(int x = 0; x < 9; x++) {
				board[y][x] = sc.nextInt();
			}
		}
	}
	
	static void playSudoku(int nowY, int nowX) {
		if(nowY == 9 && nowX == 0) {
			for(int y = 0; y < 9; y++) {
				for(int x = 0; x < 9; x++) {
					ansMaker.append(board[y][x] + " ");
				}
				ansMaker.append("\n");
			}
			System.out.print(ansMaker);
			getAnswer = true;
			return;
		}
		
		int nextX = (nowX + 1) % 9;
		int nextY = nextX == 0 ? nowY + 1: nowY;
		
		if(board[nowY][nowX] == 0) {
			for(int num = 1; num <= 9; num++) {
				if(getAnswer) return;
		
				if(isPossible(nowY, nowX, num)) {
					board[nowY][nowX] = num;
					playSudoku(nextY, nextX);
					board[nowY][nowX] = 0;
				}
			}
		}
		
		else
			playSudoku(nextY, nextX);
	}
	
	static boolean isPossible(int nowY, int nowX, int num) {
		for(int idx = 0; idx < 9; idx++) {
			if(board[nowY][idx] == num) return false;
			if(board[idx][nowX] == num) return false;
		}
		
		for(int y = 0; y < 3; y++) {
			for(int x = 0; x < 3; x++) {
				int nowNumber = board[nowY / 3 * 3 + y][nowX / 3 * 3 + x];
				if(nowNumber == num) return false;
			}
		}
		
		return true;
	}
	
}