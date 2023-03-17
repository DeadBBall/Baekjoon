import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int n;
	static int ans;
	public static void main(String[] args) {
		n = sc.nextInt();
		while(n > 0) {
			if(n % 5 == 0) {
				ans += n / 5;
				n %= 5;
			}
			else {
				ans += 1;
				n -= 2;
			}
		}
		if(n != 0) {
			ans = -1;
		}
		System.out.println(ans);
	}
}