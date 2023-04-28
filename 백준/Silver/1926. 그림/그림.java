import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static final int[] dy = { 1, -1, 0, 0 };
	static final int[] dx = { 0, 0, 1, -1 };
	static int n, m;
	static int[][] board;
	static boolean[][] visit;
	static int cnt;
	static int max;
	static int sum;

	static void input() { // 입력 메소드
		n = sc.nextInt();
		m = sc.nextInt();
		board = new int[n][m];
		visit = new boolean[n][m];
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				board[y][x] = sc.nextInt();
			}
		}
	}

	static void dfs(int y, int x) {
		visit[y][x] = true;
		sum++;
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny < 0 || nx < 0 || ny >= n || nx >= m || visit[ny][nx] || board[ny][nx] == 0) {
				continue;
			}
			dfs(ny, nx);
		}
	}

	public static void main(String[] args) {
		input();
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				if (board[y][x] == 1 && !visit[y][x]) {
					sum = 0;
					dfs(y, x);
					cnt++;
					if (max < sum) {
						max = sum;
					}
				}
			}
		}
		System.out.println(cnt);
		System.out.println(max);
	}
}