import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static char[][] board;

	static void makeStars(int y, int x) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 1 && j == 1)
					continue;
				board[i + y][j + x] = '*';
			}
		}
	}

	static void countingStars(int num, int y, int x) {
		if (num == 3) {
			makeStars(y, x);
			return;
		}
		countingStars(num / 3, y, x + num / 3);
		countingStars(num / 3, y, x + num / 3 * 2);
		countingStars(num / 3, y, x);
		countingStars(num / 3, y + num / 3, x + num / 3 * 2);
		countingStars(num / 3, y + num / 3, x);
		countingStars(num / 3, y + num / 3 * 2, x + num / 3);
		countingStars(num / 3, y + num / 3 * 2, x + num / 3 * 2);
		countingStars(num / 3, y + num / 3 * 2, x);

	}

	public static void main(String[] args) {
		n = sc.nextInt();
		board = new char[n][n];
		for(int y = 0; y < n; y++) {
			for(int x = 0; x < n; x++) {
				board[y][x] = ' ';
			}
		}
		countingStars(n, 0, 0);
		for (int y = 0; y < n; y++) {
			System.out.println(board[y]);
		}
	}
}