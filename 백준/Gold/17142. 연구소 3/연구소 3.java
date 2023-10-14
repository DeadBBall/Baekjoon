import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static final int EMPTY = 0;
	static final int WALL = 1;
	static final int VIRUS = 2;
	static final int ACTIVATEDVIRUS = -1;
	static final int[] DY = { 1, -1, 0, 0 };
	static final int[] DX = { 0, 0, 1, -1 };
	static int n, m, ans, emptyCount;
	static int[][] board;
	static boolean[][] visit;
	static List<Virus> virusList;

	public static void main(String[] args) {
		input();
		if (emptyCount == 0)
			System.out.println(0);
		else {
			choiceVirus(0, new ArrayList<Integer>());
			System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
		}
	}

	static void input() {
		n = sc.nextInt();
		m = sc.nextInt();
		board = new int[n][n];
		virusList = new ArrayList<>();
		ans = Integer.MAX_VALUE;

		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				board[y][x] = sc.nextInt();
				if (board[y][x] == VIRUS)
					virusList.add(new Virus(y, x, 0));
				else if (board[y][x] == EMPTY)
					emptyCount++;
			}
		}

	}

	static void choiceVirus(int now, List<Integer> idxList) {
		if (idxList.size() == m) {
			ans = Math.min(checkVirus(idxList), ans);
			return;
		}

		for (int idx = now; idx < virusList.size(); idx++) {
			idxList.add(idx);
			choiceVirus(idx + 1, idxList);
			idxList.remove(idxList.size() - 1);
		}

	}

	static int checkVirus(List<Integer> idxList) {
		visit = new boolean[n][n];

		Queue<Virus> virusQueue = new LinkedList<>();
		for (int num : idxList) {
			Virus nowVirus = virusList.get(num);
			virusQueue.add(nowVirus);
			visit[nowVirus.y][nowVirus.x] = true;
		}

		int time = 0;
		int nowEmptyCount = emptyCount;

		while (!virusQueue.isEmpty()) {
			Virus now = virusQueue.remove();

			if (time != now.time) {
				time++;
				if(nowEmptyCount == 0)
					 return time;
			}

			for (int dir = 0; dir < 4; dir++) {
				int ny = now.y + DY[dir];
				int nx = now.x + DX[dir];

				if (!canMove(ny, nx))
					continue;

				visit[ny][nx] = true;
				if (board[ny][nx] == EMPTY)
					nowEmptyCount--;
				virusQueue.add(new Virus(ny, nx, now.time + 1));
			}
			time = now.time;
		}
		if (nowEmptyCount == 0)
			return time;
		return Integer.MAX_VALUE;
	}

	static boolean canMove(int y, int x) {
		return !(y < 0 || x < 0 || y >= n || x >= n || board[y][x] == WALL || visit[y][x]);
	}

	static class Virus {
		int y;
		int x;
		int time;

		public Virus(int y, int x, int time) {
			this.y = y;
			this.x = x;
			this.time = time;
		}
	}
}