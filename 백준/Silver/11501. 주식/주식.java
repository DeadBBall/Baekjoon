import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int[] prices;
	static int n;
	static long profit;
	
	public static void main(String[] args) {
		int t = sc.nextInt();
		while(t-- > 0) {
			input();
			trade();
			System.out.println(profit);
		}

	}

	static void input() {
		n = sc.nextInt();
		prices = new int[n];
		for(int day = 0; day < n; day++) {
			prices[day] = sc.nextInt();
		}
		profit = 0;
	}
	
	static void trade() {
		long maxPrice = 0;
		long stockCount = 0;
		long costSum = 0;
		for(int day = n - 1; day >= 0; day--) {
			if(maxPrice == 0) maxPrice = prices[day];
			else if(maxPrice < prices[day]){
				if(stockCount > 0) {
					profit += stockCount * maxPrice - costSum;
					stockCount = 0;
				}
				maxPrice = prices[day];
				costSum = 0;
			}
			else {
				costSum += prices[day];
				stockCount++;
			}
		}
		
		if(stockCount != 0)
			profit += stockCount * maxPrice - costSum;
	}
}