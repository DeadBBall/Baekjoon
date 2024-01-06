import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static final int INF = 123456789;
	static int n, m;
	static int[][] products;
	static StringBuilder ansMaker;
	
	public static void main(String[] args) {
		input();
		compareWeight();
		System.out.print(ansMaker);
	}
	
	static void input() {
		n = SC.nextInt();
		m = SC.nextInt();
		products = new int[n + 1][n + 1];
		ansMaker = new StringBuilder();
		
		for(int left = 1; left <= n; left++) {
			for(int right = 1; right <= n; right++) {
				if(left == right) continue;
				
				products[left][right] = INF;
			}
		}
		
		for(int diffIdx = 0; diffIdx < m; diffIdx++) {
			int left = SC.nextInt();
			int right = SC.nextInt();
			
			products[left][right] = 1;
		}
	}
	
	static void compareWeight() {
		for(int mid = 1; mid <= n; mid++) {
			for(int left = 1; left <= n; left++) {
				if(left == mid) continue;
				
				for(int right = 1; right <= n; right++) {
					if(left == right || mid == right) continue;
					
					products[left][right] = Math.min(products[left][mid] + products[mid][right], products[left][right]);
				}
			}
		}
		
		for(int left = 1; left <= n; left++) {
			int count = 0;
			for(int right = 1; right <= n; right++) {
				if(left == right) continue;
				
				if(products[left][right] == INF && products[right][left] == INF) count++;
			}
			
			ansMaker.append(count + "\n");
		}
		
	}
	
}