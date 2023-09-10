import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static long x, y, z;
	static long ans;

	public static void main(String[] args) {
		input();
		playGame();
		System.out.println(ans);
	}
	
	static void input() {
		x = sc.nextInt();
		y = sc.nextInt();
		z = y * 100 / x;
		ans = -1;
	}
	
	static void playGame() {
		if(z >= 99) return;
		
		long target = z + 1;
		ans = (int) Math.ceil((x * target - 100 * y) / (double) (100 - target));
	}
	
}