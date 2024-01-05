import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static int a, b, ans;
	
	public static void main(String[] args) {
		input();
		turnOnRadio();
		System.out.println(ans);
	}
	
	static void input() {
		a = SC.nextInt();
		b = SC.nextInt();
		ans = Math.abs(a - b);
	}
	
	static void turnOnRadio() {
		int n = SC.nextInt();
		
		for(int idx = 0; idx < n; idx++) {
			int bookmark = SC.nextInt();
			ans = Math.min(Math.abs(bookmark - b) + 1, ans);
		}
		
	}
	
}