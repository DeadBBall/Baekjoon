import java.util.Scanner;

public class Main {
	
	static int n;
	static int m;
	static int l;
	static int[] friends;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		l = sc.nextInt();
		friends = new int[n + 1];
	}
	
	static void throwBall() {
		int ballIdx = 1;
		int throwNum = 0;
		while(true) {
			friends[ballIdx]++;
			if(friends[ballIdx] == m) {
				System.out.println(throwNum);
				return;
			}
			if(friends[ballIdx] % 2 == 0) {
				ballIdx -= l;
				if(ballIdx < 1) {
					ballIdx += n;
				}
			}
			else {
				ballIdx += l;
				if(ballIdx > n) {
					ballIdx -= n;
				}
			}
			throwNum++;
		}
	}
	
	static void solve() {
		input();
		throwBall();
	}
	
	public static void main(String[] args) {
		solve();
	}
}