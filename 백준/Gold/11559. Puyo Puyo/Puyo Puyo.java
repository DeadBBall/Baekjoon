import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static final char RED = 'R';
	static final char GREEN = 'G';
	static final char BLUE = 'B';
	static final char PURPLE = 'P';
	static final char YELLOW = 'Y';
	static final char EMPTY = '.';
	static final int[] DY = { 1, -1, 0, 0 };
	static final int[] DX = { 0, 0, 1, -1 };
	static char[][] board;
	static boolean[][] visit;
	static int ans;

	public static void main(String[] args) {
		input();
		playPuyoPuyo();
		System.out.println(ans);
	}

	static void input() {
		board = new char[12][6];
		visit = new boolean[12][6];

		for (int y = 0; y < 12; y++) {
			String inputLine = SC.next();
			board[y] = inputLine.toCharArray();
		}
	}

	static void playPuyoPuyo() {
		boolean finish = false;

		while (!finish) {
			finish = searchPuyo();
//			for (int y = 0; y < 12; y++) {
//				for (int x = 0; x < 6; x++) {
//					System.out.print(board[y][x]);
//				}
//				System.out.println();
//			}
//			System.out.println();
			if (!finish)
				ans++;
		}
	}

	static boolean searchPuyo() {
		boolean canPuyo = false;

		for (int y = 0; y < 12; y++) {
			Arrays.fill(visit[y], false);
		}

		for (int y = 11; y >= 0; y--) {
			for (int x = 0; x < 6; x++) {
				char nowPuyo = board[y][x];

				if (nowPuyo != EMPTY && !visit[y][x]) {
					int puyoCount = countPuyo(y, x);
					
					if (puyoCount >= 4) {
						bombPuyo(y, x);
						canPuyo = true;
					}
				}
			}
		}

		if (canPuyo)
			sortPuyo();

		return !canPuyo;
	}

	static int countPuyo(int y, int x) {
		int puyoCount = 1;
		Queue<Puyo> puyoQueue = new LinkedList<>();
		puyoQueue.add(new Puyo(y, x, board[y][x]));
		visit[y][x] = true;

		while (!puyoQueue.isEmpty()) {
			Puyo now = puyoQueue.remove();

			for (int drct = 0; drct < 4; drct++) {
				int ny = now.y + DY[drct];
				int nx = now.x + DX[drct];

				if (!canMove(ny, nx))
					continue;
				if (visit[ny][nx])
					continue;

				if (board[ny][nx] == now.color) {
					visit[ny][nx] = true;
					puyoQueue.add(new Puyo(ny, nx, now.color));
					puyoCount++;
				}

			}
		}
		return puyoCount;
	}

	static boolean canMove(int y, int x) {
		return y >= 0 && y < 12 && x >= 0 && x < 6;
	}

	static void bombPuyo(int y, int x) {
		Queue<Puyo> puyoQueue = new LinkedList<>();
		puyoQueue.add(new Puyo(y, x, board[y][x]));
		board[y][x] = EMPTY;

		while (!puyoQueue.isEmpty()) {
			Puyo now = puyoQueue.remove();

			for (int drct = 0; drct < 4; drct++) {
				int ny = now.y + DY[drct];
				int nx = now.x + DX[drct];

				if (!canMove(ny, nx))
					continue;

				if (board[ny][nx] == now.color) {
					board[ny][nx] = EMPTY;
					puyoQueue.add(new Puyo(ny, nx, now.color));
				}

			}
		}
	}

	static void sortPuyo() {
		for (int x = 0; x < 6; x++) {
			for (int y = 10; y >= 0; y--) {

				if (board[y][x] != EMPTY) {

					for (int ny = y + 1; ny < 12; ny++) {
						if (board[ny][x] == EMPTY) {
							board[ny][x] = board[ny - 1][x];
							board[ny - 1][x] = EMPTY;
						}
					}
				}
			}
		}
	}

}

class Puyo {
	int y;
	int x;
	char color;

	public Puyo(int y, int x, char color) {
		this.y = y;
		this.x = x;
		this.color = color;
	}

}