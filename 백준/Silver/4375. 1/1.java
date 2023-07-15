import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static int ans;
	
	static void input() {
		n = sc.nextInt();
		ans = 1;
	}
	
	static void searchNum() {
		long num = 1;
		while(true) {
			if(num % n == 0) {
				return;
			}
			num *= 10;
			num++;
			num %= n;
			ans++;
		}
	}
	
	public static void main(String[] args) {
		while(sc.hasNextInt()) {
			input();
			searchNum();
			System.out.println(ans);
		}
	}
}