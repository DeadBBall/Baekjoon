import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static int m;
	static int[][] board;
	
	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();
		board = new int[n + 1][m + 1];
		int num = 0;
		for(int y = 1; y <= n; y++) {
			for(int x = 1; x <= m; x++) {
				board[y][x] = sc.nextInt();
				
				num = Math.max(board[y - 1][x], board[y][x - 1]);
				board[y][x] += num;
			}
		}
		System.out.println(board[n][m]);
	}
}