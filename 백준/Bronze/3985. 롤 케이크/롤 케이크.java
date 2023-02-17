import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int l;
	static int n;
	static boolean[] cake;
	static int[][] observers;
	static int ans;
	static int realAns;
	
	static void input() {
		l = Integer.parseInt(sc.nextLine());
		n = Integer.parseInt(sc.nextLine());
		cake = new boolean[l + 1];
		observers = new int[n + 1][2];
		for(int i = 1; i <= n; i++) {
			String[] tmpInput = sc.nextLine().split(" ");
			observers[i][0] = Integer.parseInt(tmpInput[0]);
			observers[i][1] = Integer.parseInt(tmpInput[1]);
		}
	}

	static void eatCake() {
		int maxCake = 0;
		int realMaxCake = 0;
		for(int i = 1; i <= n; i++) {
			int tmpMaxCake = 0;
			int left = observers[i][0];
			int right = observers[i][1];
			if(maxCake < right - left + 1) {
				ans = i;
				maxCake = right - left + 1;
			}
			for(int j = left; j <= right; j++) {
				if(!cake[j]) {
					cake[j] = true;
					tmpMaxCake++;
				}
			}
			if(realMaxCake < tmpMaxCake) {
				realMaxCake = tmpMaxCake;
				realAns = i;
			}
		}
	}
	
	static void solve() {
		input();
		eatCake();
		System.out.println(ans);
		System.out.println(realAns);
	}

	public static void main(String[] args) {
		solve();
	}
}