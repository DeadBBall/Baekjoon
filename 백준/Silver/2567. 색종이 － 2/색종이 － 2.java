import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int n;
	static boolean[][] map;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };
	static int ans;

	static void fillMap(int startY, int startX) {
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				map[y + startY][x + startX] = true;
			}
		}
	}

	static void input() {
		n = Integer.parseInt(sc.nextLine());
		map = new boolean[100][100];
		for (int i = 0; i < n; i++) {
			String[] inputTmp = sc.nextLine().split(" ");
			fillMap(Integer.parseInt(inputTmp[1]), Integer.parseInt(inputTmp[0]));
		}
	}

	static void checkColorPaper() {
		for (int y = 0; y < 100; y++) {
			for (int x = 0; x < 100; x++) {
				if (map[y][x]) {
					int cnt = 0;
					for (int i = 0; i < 4; i++) {
						int ny = y + dy[i];
						int nx = x + dx[i];
						if (ny < 0 || nx < 0 || ny >= 100 || nx >= 100) {
							cnt++;
							continue;
						}
						if (!map[ny][nx]) {
							cnt++;
						}
					}
					if (cnt == 2) {
						ans++;
					}
					if (cnt != 0) {
						ans++;
					}
				}
			}
		}
	}

	static void solve() {
		input();
		checkColorPaper();
		System.out.println(ans);
	}

	public static void main(String[] args) {
		solve();
	}
}
