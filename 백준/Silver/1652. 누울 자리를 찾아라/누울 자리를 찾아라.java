import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int n;
	static String[] board;
	static boolean[][] visit;
	static int ansY;
	static int ansX;
	public static void main(String[] args) {
		n = sc.nextInt();
		board = new String[n];
		for(int i = 0; i < n; i++) {
			board[i] = sc.next();
		}
		
		visit = new boolean[n][n];
		for(int y = 0; y < n; y++) {
			int length = 0;
			for(int x = 0; x < n; x++) {
				if(board[y].charAt(x) == '.' && !visit[y][x]) {
					visit[y][x] = true;
					length++;
				}
				if(board[y].charAt(x) == 'X' || x == n - 1) {
					if(length >= 2) {
						ansX++;
					}
					length = 0;
				}
			}
		}
		
		visit = new boolean[n][n];
		for(int x = 0; x < n; x++) {
			int length = 0;
			for(int y = 0; y < n; y++) {
				if(board[y].charAt(x) == '.' && !visit[y][x]) {
					visit[y][x] = true;
					length++;
				}
				if(board[y].charAt(x) == 'X' || y == n - 1) {
					if(length >= 2) {
						ansY++;
					}
					length = 0;
				}
			}
		}
		System.out.println(ansX + " " + ansY);
	}
}