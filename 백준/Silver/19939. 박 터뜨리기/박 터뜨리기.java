import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int n, k, ans;

	public static void main(String[] args) {
		input();
		breakGourd();
		System.out.println(ans);
	}

	static void input() {
		n = sc.nextInt();
		k = sc.nextInt();
		ans = -1;
	}
	
	static void breakGourd() {
		int sum = k * (k + 1) / 2;
		if(n < sum) return;
		n -= sum;
		
		ans = k - 1;
		
		if(n % k != 0) ans++;
	}

}