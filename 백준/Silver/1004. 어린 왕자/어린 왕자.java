import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int startX, startY, endX, endY;
	static int n;
	static int ans;
	
	public static void main(String[] args) {
		int t;
		t = sc.nextInt();
		while(t-- > 0) { 
			input();
			travel();
			System.out.println(ans);
		}
	}

	static void input() {
		startX = sc.nextInt();
		startY = sc.nextInt();
		endX = sc.nextInt();
		endY = sc.nextInt();
		n = sc.nextInt();
		ans = 0;
	}
	
	static void travel() {
		for(int i = 0; i < n; i++) {
			int starX = sc.nextInt();
			int starY = sc.nextInt();
			int radius = sc.nextInt();
			
			if(isContained(starX, starY, radius)) ans++;
			
		}
	}
	
	static boolean isContained(int starX, int starY, int radius) {
		int diffStartSquare = (int)(Math.pow(starX - startX, 2) + Math.pow(starY - startY, 2));
		int diffEndSquare = (int)(Math.pow(starX - endX, 2) + Math.pow(starY - endY, 2));
		int radiusSquare = (int)(Math.pow(radius, 2));
		
		if(diffStartSquare <= radiusSquare && diffEndSquare <= radiusSquare) return false;
		
		else if(diffStartSquare > radiusSquare && diffEndSquare > radiusSquare) return false;
		
		return true;
	}
	
}