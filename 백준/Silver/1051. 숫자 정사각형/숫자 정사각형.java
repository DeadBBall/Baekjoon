import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int n;
	static int m;
	static String[] board;
	static int ans;
	
	
	public static void main(String[] args) {
		input();
		searchLargestsquare();
		System.out.println(ans);
	}
	
	static void input() {
		n = sc.nextInt();
		m = sc.nextInt();
		
		board = new String[n];
		ans = 1;
		
		for(int idx = 0; idx < n; idx++) {
			board[idx] = sc.next();
		}
		
	}
	
	static boolean checkSquare(int y, int x, int size) {
		
		char original = board[y].charAt(x);
		
		if(original != board[y + size].charAt(x)) return false;
		
		if(original != board[y].charAt(x + size)) return false;
		
		if(original != board[y + size].charAt(x + size)) return false;
		
		return true;
		
	}
	
	static void searchLargestsquare() {
		int maxSize = Math.min(n, m);
		
		for(int size = maxSize; size > 1; size--) {
			
			for(int y = 0; y < n - size + 1; y++) {
				
				for(int x = 0; x < m - size + 1; x++) {
					
					if(checkSquare(y, x, size - 1)) {
						ans = size * size;
						return;
					}
					
				}
				
			}
			
		}
	}
	
}