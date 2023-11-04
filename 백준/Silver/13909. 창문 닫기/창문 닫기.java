import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static int ans;
	
	public static void main(String[] args) {
		input();
		closeWindow();
		System.out.println(ans);
	}
	
	static void input() {
		n = sc.nextInt();
	}
	
	static void closeWindow() {
		for(int num = 1; ;num++) {
			int powNum = (int)Math.pow(num, 2);
			if(powNum > n) {
				ans = num - 1;
				return;
			}
			else if(powNum == n) {
				ans = num;
				return;
			}
		}
	}
}
