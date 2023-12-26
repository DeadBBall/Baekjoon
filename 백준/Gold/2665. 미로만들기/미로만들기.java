import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static final int[] DY = { 1, -1, 0, 0 };
	static final int[] DX = { 0, 0, 1, -1 };
	static final int WALL = 0;
	static final int EMPTY = 1;
	static final int INF = 3000;
	static int n, ans;
	static int[][] board;
	static int[][] visit;

	public static void main(String[] args) {
		input();
		makeMaze();
		System.out.println(ans);
	}

	static void input() {
		n = SC.nextInt();
		board = new int[n][n];
		visit = new int[n][n];

		for (int y = 0; y < n; y++) {
			String inputBoard = SC.next();
			for (int x = 0; x < n; x++) {
				board[y][x] = inputBoard.charAt(x) - '0';
				visit[y][x] = INF;
			}
		}
		visit[0][0] = 0;
	}

	static void makeMaze() {
		PriorityQueue<Position> positionQueue = new PriorityQueue<>(new Comparator<Position>() {
			@Override
			public int compare(Position a, Position b) {
				return a.removalCount - b.removalCount;
			}
		});
		positionQueue.add(new Position(0, 0, 0));

		while (!positionQueue.isEmpty()) {
			Position now = positionQueue.remove();
//			System.out.println("y: " + now.y + " x: " + now.x + " cnt: " + now.removalCount);
			
			if (now.y == n - 1 && now.x == n - 1) {
				ans = now.removalCount;
				return;
			}

			for (int drct = 0; drct < 4; drct++) {
				int ny = now.y + DY[drct];
				int nx = now.x + DX[drct];

				if (!canMove(ny, nx)) continue;

				if (board[ny][nx] == EMPTY && visit[ny][nx] > now.removalCount) {
					visit[ny][nx] = now.removalCount;
					positionQueue.add(new Position(ny, nx, now.removalCount));
				}

				else if (board[ny][nx] == WALL && visit[ny][nx] > now.removalCount + 1) {
					visit[ny][nx] = now.removalCount + 1;
					positionQueue.add(new Position(ny, nx, now.removalCount + 1));
				}
			}
		}
	}

	static boolean canMove(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < n;
	}

}

class Position {
	int y;
	int x;
	int removalCount;

	public Position(int y, int x, int removalCount) {
		this.y = y;
		this.x = x;
		this.removalCount = removalCount;
	}

}