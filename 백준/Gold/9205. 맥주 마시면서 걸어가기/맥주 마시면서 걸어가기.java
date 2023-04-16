import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static int t;
	static int[] house;
	static int[][] store;
	static int[] festival;
	static StringBuilder ansMaker = new StringBuilder();
	static boolean[] visit;

	static void input() {
		n = sc.nextInt();
		house = new int[2];
		for (int i = 0; i < 2; i++) {
			house[i] = sc.nextInt();
		}
		store = new int[n][2];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				store[i][j] = sc.nextInt();
			}
		}
		festival = new int[2];
		for (int i = 0; i < 2; i++) {
			festival[i] = sc.nextInt();
		}
		visit = new boolean[n];
	}

	static boolean goFestival() {
		Queue<int[]> q = new LinkedList<>();
		q.add(house);
		while (!q.isEmpty()) {
			int[] now = q.remove();
			if (Math.abs(festival[0] - now[0]) + Math.abs(festival[1] - now[1]) <= 1000) {
				return true;
			}
			for (int j = 0; j < n; j++) {
					if (!visit[j] && Math.abs(now[0] - store[j][0]) + Math.abs(now[1] - store[j][1]) <= 1000) {
						visit[j] = true;
						q.add(store[j]);
					}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			input();
			ansMaker.append(goFestival() ? "happy" : "sad").append("\n");
		}
		System.out.println(ansMaker);
	}
}