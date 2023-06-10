import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n, m, j;
	static int left, right;
	static int ans;
	
	static void input() {
		n = sc.nextInt();
		m = sc.nextInt();
		j = sc.nextInt();
		left = 1;
		right = m;
	}
	
	static void playGame() {
		for(int i = 0; i < j; i++) {
			int apple = sc.nextInt();
			if(left <= apple && apple <= right) {
				continue;
			}
			if(apple < left) {
				ans += left - apple;
				left = apple;
				right = left + m - 1;
			}
			else {
				ans += apple - right;
				right = apple;
				left = right - m + 1;
			}
		}
	}

	public static void main(String[] args) {
		input();
		playGame();
		System.out.println(ans);
	}
}