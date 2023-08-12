import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	static final int[] dy = { 1, -1, 0, 0 };
	static final int[] dx = { 0, 0, 1, -1 };

	static int n;
	static int m;
	static int[][] board;
	static boolean[][] visit;
	static Queue<int[]> icebergQueue;
	static int[][] newBoard;
	static int ans;

	public static void main(String[] args) {
		input();
		meltIceberg();
		System.out.println(icebergQueue.size() == 0 ? 0 : ans);		
	}

	static void input() {
		n = sc.nextInt();
		m = sc.nextInt();

		board = new int[n][m];
		visit = new boolean[n][m];
		icebergQueue = new LinkedList<>();
		newBoard = new int[n][m];

		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {

				board[y][x] = sc.nextInt();
				if (board[y][x] != 0)
					icebergQueue.add(new int[] { y, x });

			}
		}

	}

	static void meltIceberg() {
		while (!icebergQueue.isEmpty()) {
			passYear();
			ans++;
			if(countIceberg()) return;
		}

	}

	static void passYear() {
		int size = icebergQueue.size();
		
		for(int y = 0; y < n; y++) {
			for(int x = 0; x < m; x++) {
				newBoard[y][x] = board[y][x];
			}
		}
		
		for (int idx = 0; idx < size; idx++) {
			int[] nowCoo = icebergQueue.remove();
			int y = nowCoo[0];
			int x = nowCoo[1];
			int seaSum = 0;

			for (int drct = 0; drct < 4; drct++) {
				int ny = y + dy[drct];
				int nx = x + dx[drct];

				if (ny < 0 || nx < 0 || ny >= n || nx >= m)
					continue;

				if (board[ny][nx] == 0)
					seaSum++;
			}
			
			if (board[y][x] <= seaSum)
				newBoard[y][x] = 0;
			else {
				newBoard[y][x] = board[y][x] - seaSum;
				icebergQueue.add(new int[] { y, x });
			}

		}
		
		for(int y = 0; y < n; y++) {
			for(int x = 0; x < m; x++) {
				board[y][x] = newBoard[y][x];
			}
		}
		
	}

	static boolean countIceberg() {
		int sum = 0;
		
		for(int idx = 0; idx < icebergQueue.size(); idx++) {
			int[] nowCoo = icebergQueue.remove();
			visit[nowCoo[0]][nowCoo[1]] = false;
			icebergQueue.add(new int[] {nowCoo[0], nowCoo[1]});
		}
		
		for(int idx = 0; idx < icebergQueue.size(); idx++) {
			int[] nowCoo = icebergQueue.remove();
			int y = nowCoo[0];
			int x = nowCoo[1];
			
			if(!visit[y][x]) {
				sum++;
				dfs(y, x);
			}
			
			icebergQueue.add(new int[] {nowCoo[0], nowCoo[1]});
		}
		
		if(sum > 1) return true;
		return false;
	}

	static void dfs(int y, int x) {
		visit[y][x] = true;
		for(int drct = 0; drct < 4; drct++) {
			int ny = y + dy[drct];
			int nx = x + dx[drct];
			
			if(ny < 0 || nx < 0 || ny >= n || nx >= m || board[ny][nx] == 0 || visit[ny][nx]) continue;
			
			dfs(ny, nx);
		}
		
	}

}