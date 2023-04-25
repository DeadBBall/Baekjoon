import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n, m;
	static char[][] board;
	static char[][] obj;
	static int ans;
	
	static void input() { // 입력 메소드
		n = sc.nextInt();
		m = sc.nextInt();
		board = new char[n][m];
		obj = new char[n][m];
		for(int y = 0; y < n; y++) {
			board[y] = sc.next().toCharArray();
		}
		for(int y = 0; y < n; y++) {
			obj[y] = sc.next().toCharArray();
		}
	}
	
	static int countDiff(int yStart, int xStart) {
		int sum = 0;
		for(int y = 0; y < 3; y++) {
			for(int x = 0; x < 3; x++) {
				if(board[y + yStart][x + xStart] != obj[y + yStart][x + xStart]) {
					sum++;
				}
			}
		}
		return sum;
	}
	
	static void reverseBoard(int yStart, int xStart) {
		for(int y = 0; y < 3; y++) {
			for(int x = 0; x < 3; x++) {
				board[y + yStart][x + xStart] = board[y + yStart][x + xStart] == '0' ? '1' : '0'; 
			}
		}
	}
	
	static int checkAll() {
		int ans = 0;
		if(n < 3 || m < 3) {
			int tmpSum = 0;
			for(int y = 0; y < n; y++) {
				for(int x = 0; x < m; x++) {
					if(board[y][x] != obj[y][x]) {
						tmpSum++;
					}
				}
			}
			return tmpSum == 0 ? 0 : -1;
		}
		while(true) {
			for(int y = 0; y < n - 2; y++) {
				for(int x = 0; x < m - 2; x++) {
					if(board[y][x] != obj[y][x]) {
						reverseBoard(y, x);
						ans++;						
					}
				}
			}
			int tmpSum = 0;
			for(int y = 0; y < n - 2; y++) {
				for(int x = 0; x < m - 2; x++) {
					tmpSum += countDiff(y, x);
				}
			}
			if(tmpSum == 0) {
				return ans;
			}
			return -1;
		}
	}
	
	public static void main(String[] args) {
		input();
		System.out.println(checkAll());
	}
}