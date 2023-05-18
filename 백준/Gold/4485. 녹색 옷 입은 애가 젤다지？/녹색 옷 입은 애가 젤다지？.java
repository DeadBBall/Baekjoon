import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static final int[] dy = { 1, -1, 0, 0 };
	static final int[] dx = { 0, 0, 1, -1 };
	static final int INF = Integer.MAX_VALUE;
	static int n;
	static int[][] board;
	static int[][] cost;

	static class Line {
		int y;
		int x;
		int dist;

		public Line(int y, int x, int dist) {
			this.y = y;
			this.x = x;
			this.dist = dist;
		}

		
	}

	static void input() {
		board = new int[n][n];
		cost = new int[n][n];
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				board[y][x] = sc.nextInt();
				cost[y][x] = INF;
			}
		}
	}

	static void move() {
		PriorityQueue<Line> pq = new PriorityQueue<>(new Comparator<Line>() {

			@Override
			public int compare(Line o1, Line o2) {
				return o1.dist - o2.dist;
			}
			
		});
		pq.add(new Line(0, 0, board[0][0]));
		while(!pq.isEmpty()) {
			Line now = pq.remove();
			for(int i = 0; i < 4; i++) {
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];
				if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
					continue;
				}
				if(now.dist + board[ny][nx] < cost[ny][nx]) {
					cost[ny][nx] = now.dist + board[ny][nx];
					pq.add(new Line(ny, nx, cost[ny][nx]));
				}
			}
		}
	}

	public static void main(String[] args) {
		for (int i = 1;; i++) {
			n = sc.nextInt();
			if (n == 0) {
				return;
			}
			input();
			move();
			System.out.println("Problem " + i + ": " + cost[n - 1][n - 1]);
		}
	}
}