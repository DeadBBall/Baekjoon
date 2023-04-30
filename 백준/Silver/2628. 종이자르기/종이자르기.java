import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n, m;
	static boolean[] xArr;
	static boolean[] yArr;
	static int ans;

	static void input() {
		n = sc.nextInt();
		m = sc.nextInt();
		xArr = new boolean[n];
		yArr = new boolean[m];
		int cnt = sc.nextInt();
		for (int i = 0; i < cnt; i++) {
			int dir = sc.nextInt();
			int num = sc.nextInt();
			if (dir == 0) {
				yArr[num] = true;
			} else {
				xArr[num] = true;
			}
		}
	}

	static void cutPaper() {
		int maxY = 0;
		int maxX = 0;

		int len = 0;
		for (int y = 0; y < m; y++) {
			if (yArr[y]) {
				maxY = Math.max(maxY, len);
				len = 1;
			} else {
				len++;
			}
		}
		maxY = Math.max(maxY, len);
		len = 0;
		for (int x = 0; x < n; x++) {
			if (xArr[x]) {
				maxX = Math.max(maxX, len);
				len = 1;
			} else {
				len++;
			}
		}
		maxX = Math.max(maxX, len);
		ans = maxX * maxY;
	}

	public static void main(String[] args) {
		input();
		cutPaper();
		System.out.println(ans);
	}
}