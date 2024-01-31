import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static int n, m, ans;
	
	public static void main(String[] args) {
		input();
		installStreetLamp();
		System.out.println(ans);
	}

	static void input() {
		n = SC.nextInt();
		m = SC.nextInt();
	}
	
	static void installStreetLamp() {
		int prev = 0;
		int now = SC.nextInt();

		ans = now - prev;
		
		prev = now;
		
		for(int lampIdx = 1; lampIdx < m; lampIdx++) {
			now = SC.nextInt();
			
			int height = (now - prev + 1) / 2; 
			
			ans = Math.max(height, ans);
			
			prev = now;	
		}
		
		ans = Math.max(n - now, ans);
	}
	
}