import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static int ans;

	static void input() {
		n = sc.nextInt();
		ans = 0;
	}

	static void countNum() {
		int left = 1;
		int right = 1;
		int sum = 1;
		while(right <= (n / 2) + 1) {
			if(sum == n) {
				ans++;
				right++;
				sum += right;
			}
			else if(sum > n) {
				sum -= left;
				left++;
			}
			else {
				right++;
				sum += right;
			}
		}
		if(n == 2) {
			ans--;
		}
	}
	
	public static void main(String[] args) {
		input();
		countNum();
		System.out.println(n == 1 ? ans : ans + 1);
	}
}