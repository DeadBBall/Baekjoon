import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int[] x = new int[2];
	static int[] y = new int[2];
	static int[] p = new int[2];
	static int[] q = new int[2];

	static void input() {
		for (int i = 0; i < 2; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
			p[i] = sc.nextInt();
			q[i] = sc.nextInt();
		}
	}

	static void checkRectangle() {
		if (p[0] < x[1] || q[0] < y[1] || p[1] < x[0] || q[1] < y[0]) {
			System.out.println("d");
		} else if ((x[0] == p[1] && y[0] == q[1]) || (x[0] == p[1] && q[0] == y[1]) || (p[0] == x[1] && q[0] == y[1])
				|| (p[0] == x[1] && y[0] == q[1])) {
			System.out.println("c");
		} else if (x[1] == p[0] || q[0] == y[1] || p[1] == x[0] || y[0] == q[1]) {
			System.out.println("b");
		} else {
			System.out.println("a");
		}
	}

	static void solve() {
		for (int i = 0; i < 4; i++) {
			input();
			checkRectangle();
		}
	}

	public static void main(String[] args) {
		solve();
	}
}