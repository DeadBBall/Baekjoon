import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static Integer[] costs;
	static int n, ans;
	
	public static void main(String[] args) {
		input();
		buyDairyProducts();
		System.out.println(ans);
	}	
	
	static void input() {
		n = sc.nextInt();
		costs = new Integer[n];
		
		for(int productIdx = 0; productIdx < n; productIdx++) {
			costs[productIdx] = sc.nextInt();
		}
		Arrays.sort(costs, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1; 
			}
		});
		
	}
	
	static void buyDairyProducts() {
		for(int productIdx = 0; productIdx < n; productIdx++) {
			if((productIdx + 1) % 3 == 0) continue;
			ans += costs[productIdx];
		}
	}
	
}