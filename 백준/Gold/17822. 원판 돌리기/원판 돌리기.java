import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int n;
	static int m;
	static int t;
	static int[][] board;
	static int ans;

	static void input() {
		n = sc.nextInt();
		m = sc.nextInt();
		t = sc.nextInt();
		board = new int[n + 2][m + 2];
		for (int y = 1; y <= n; y++) {
			for (int x = 1; x <= m; x++) {
				board[y][x] = sc.nextInt();
			}
		}
	}

	static void checkNear() {
		boolean[][] check = new boolean[n + 2][m + 2];
		boolean flag = false;
		int sum = 0;
		int cnt = 0;
		for (int y = 1; y <= n; y++) {
			for (int x = 1; x <= m; x++) {
				if (board[y][x] != 0) {
					sum += board[y][x];
					cnt++;
					if (board[y][x] == board[y + 1][x]) {
						flag = true;
						check[y][x] = true;
						check[y + 1][x] = true;
					}
					if (board[y][x] == board[y - 1][x]) {
						flag = true;
						check[y][x] = true;
						check[y - 1][x] = true;
					}
					if (x == 1) {
						if (board[y][x] == board[y][m]) {
							flag = true;
							check[y][x] = true;
							check[y][m] = true;
						}
						if (board[y][x] == board[y][2]) {
							flag = true;
							check[y][x] = true;
							check[y][2] = true;
						}
					} else if (x == m) {
						if (board[y][x] == board[y][m - 1]) {
							flag = true;
							check[y][x] = true;
							check[y][m - 1] = true;
						}
						if (board[y][x] == board[y][1]) {
							flag = true;
							check[y][x] = true;
							check[y][1] = true;
						}
					} else {
						{
							if (board[y][x] == board[y][x - 1]) {
								flag = true;
								check[y][x] = true;
								check[y][x - 1] = true;
							}
							if (board[y][x] == board[y][x + 1]) {
								flag = true;
								check[y][x] = true;
								check[y][x + 1] = true;
							}
						}
					}
				}
			}
		}
		if (flag) {
			for (int y = 1; y <= n; y++) {
				for (int x = 1; x <= m; x++) {
					if (check[y][x]) {
						board[y][x] = 0;
					}
				}
			}
		} else {
			double avg = (double) sum / cnt;
			for (int y = 1; y <= n; y++) {
				for (int x = 1; x <= m; x++) {
					if (board[y][x] != 0 && board[y][x] < avg) {
						board[y][x]++;
					} else if (board[y][x] != 0 && board[y][x] > avg) {
						board[y][x]--;
					}
				}
			}
		}
	}

	static void turn() {
		for (int tCnt = 0; tCnt < t; tCnt++) {
			int c, d, k;
			c = sc.nextInt();
			d = sc.nextInt();
			k = sc.nextInt();
			if (d == 1) {
				k = m - k;
			}
			for (int i = c; i <= n; i += c) {
				for (int j = 0; j < k; j++) {
					int tmp = board[i][m];
					for (int x = m - 1; x >= 1; x--) {
						board[i][x + 1] = board[i][x];
					}
					board[i][1] = tmp;
				}
			}
			checkNear();
//			System.out.println();
//			for (int y = 1; y <= n; y++) {
//				for (int x = 1; x <= m; x++) {
//					System.out.print(board[y][x] + " ");
//				}
//				System.out.println();
//			}
		}
		for (int y = 1; y <= n; y++) {
			for (int x = 1; x <= m; x++) {
				ans += board[y][x];
			}
		}
	}

	public static void main(String[] args) {
		input();
		turn();
		System.out.println(ans);
	}
}