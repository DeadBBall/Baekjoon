import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static char[][] board;
	static Set<Integer>[] ySet = new HashSet[9];
	static Set<Integer>[] xSet = new HashSet[9];
	static Set<Integer>[] restSet = new HashSet[9];
	static List<int[]> zeroList;
	static boolean flag;
	
	public static void main(String[] args) {
		input();
		playSudoku(0);
		printBoard();
	}

	static void input() {
		board = new char[9][9];
		zeroList = new ArrayList<>();

		for (int idx = 0; idx < 9; idx++) {
			board[idx] = sc.next().toCharArray();

			ySet[idx] = new HashSet<>();
			xSet[idx] = new HashSet<>();
			restSet[idx] = new HashSet<>();
		}		

		for (int y = 0; y < 9; y++) {

			for (int x = 0; x < 9; x++) {

				if (board[y][x] != '0') {
					ySet[x].add(board[y][x] - '0');
					xSet[y].add(board[y][x] - '0');
					restSet[y / 3 * 3 + x / 3].add(board[y][x] - '0');
                    
				} else {
					zeroList.add(new int[] { y, x });
				}

			}

		}

	}

	static boolean checkInput(int y, int x, int num) {
		
		if(ySet[x].contains(num)) return false;
		
		if(xSet[y].contains(num)) return false;
		
		if(restSet[y / 3 * 3 + x / 3].contains(num)) return false;
		
		board[y][x] = (char)(num + '0');
		ySet[x].add(num);
		xSet[y].add(num);
		restSet[y / 3 * 3 + x / 3].add(num);
		
		return true;
	}
	
	static void returnBoard(int y, int x, int num) {
		board[y][x] = '0';
		ySet[x].remove(num);
		xSet[y].remove(num);
		restSet[y / 3 * 3 + x / 3].remove(num);
	}
	
	
	static void playSudoku(int idx) {
		if(idx == zeroList.size()) {
			flag = true;
			return;
		}

		for(int num = 1; num <= 9; num++) {
			int yIdx = zeroList.get(idx)[0];
			int xIdx = zeroList.get(idx)[1];
            
			if(checkInput(yIdx, xIdx, num)) {
				playSudoku(idx + 1);
                
				if(flag == true) return;
                
				returnBoard(yIdx, xIdx, num);
			}
		}
		
	}
	
	static void printBoard() {
		for(int y = 0; y < 9; y++) {
			for(int x = 0; x < 9; x++) {
				System.out.print(board[y][x]);
			}
			System.out.println();
		}
	}

}
