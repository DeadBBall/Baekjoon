import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static int n, m, ans;
	static int[][] pictures;

	public static void main(String[] args) {
		input();
		countPicture();
		System.out.println(ans);
	}

	static void input() {
		n = SC.nextInt();
		m = SC.nextInt();

		pictures = new int[101][101];
	}

	static void countPicture() {
		for (int idx = 0; idx < n; idx++) {
			int x1 = SC.nextInt();
			int y1 = SC.nextInt();
			int x2 = SC.nextInt();
			int y2 = SC.nextInt();

			for (int y = y1; y <= y2; y++) {
				for (int x = x1; x <= x2; x++) {
					pictures[y][x]++;
					
					if(pictures[y][x] == m + 1) ans++;
				}
			}
		}
	}

}