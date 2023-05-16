import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int r, c;
	static String[] board;
	static int wolf, sheep;
	static boolean[][] visit;
	static final int[] dy = { 1, -1, 0, 0 };
	static final int[] dx = { 0, 0, 1, -1 };

	static void input() {
		r = sc.nextInt();
		c = sc.nextInt();
		board = new String[r];
		for (int y = 0; y < r; y++) {
			board[y] = sc.next();
		}
		visit = new boolean[r][c];
	}

	static void bfs(int y, int x) {
		int tmpWolf = 0;
		int tmpSheep = 0;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { y, x });
		while (!q.isEmpty()) {
			int[] now = q.remove();
			int nowChar = board[now[0]].charAt(now[1]);
			if (nowChar == 'v') {
				tmpWolf++;
			} else if (nowChar == 'o') {
				tmpSheep++;
			}
			for (int i = 0; i < 4; i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];
				if (ny < 0 || nx < 0 || ny >= r || nx >= c || visit[ny][nx] || board[ny].charAt(nx) == '#') {
					continue;
				}
				visit[ny][nx] = true;
				q.add(new int[] { ny, nx });
			}
		}
		if (tmpWolf >= tmpSheep) {
			wolf += tmpWolf;
		} else {
			sheep += tmpSheep;
		}
	}

	static void warInBackyard() {
		for (int y = 0; y < r; y++) {
			for (int x = 0; x < c; x++) {
				char now = board[y].charAt(x);
				if ((now == 'o' || now == 'v') && !visit[y][x]) {
					visit[y][x] = true;
					bfs(y, x);
				}
			}
		}
	}

	public static void main(String[] args) {
		input();
		warInBackyard();
		System.out.println(sheep + " " + wolf);
	}
}