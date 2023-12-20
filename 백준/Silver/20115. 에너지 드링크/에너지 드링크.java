import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static int n;
	static double ans;

	public static void main(String[] args) {
		input();
		makeEnergyDrink();
		System.out.println(ans);
	}

	static void input() {
		n = SC.nextInt();
	}
	
	static void makeEnergyDrink() {
		int maxDrink = 0;
		for(int drinkIdx = 0; drinkIdx < n; drinkIdx++) {
			int nowDrink = SC.nextInt();
			maxDrink = Math.max(maxDrink, nowDrink);
			ans += (double)nowDrink / 2;
		}
		ans += (double)maxDrink / 2;
	}

}