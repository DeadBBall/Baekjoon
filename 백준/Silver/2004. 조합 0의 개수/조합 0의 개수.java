import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int n, m, ans;

	public static void main(String[] args) {
		input();
		countZero();
		System.out.println(ans);
	}

	static void input() {
		n = sc.nextInt();
		m = sc.nextInt();
	}

	static void countZero() {
		if(m == 0) return;
		int fiveCount;
		int twoCount;
		
		fiveCount = countFive(n) - countFive(n - m) - countFive(m);
		twoCount =  countTwo(n) - countTwo(n - m) - countTwo(m);
		
		ans = fiveCount > twoCount ? twoCount : fiveCount;
	}

	static int countFive(int num) {
		int count = 0;
		while(num > 0) {
			count += num / 5;
			num /= 5;
		}
		return count;
	}
	
	static int countTwo(int num) {
		int count = 0;
		while(num > 0) {
			count += num / 2;
			num /= 2;
		}
		return count;
	}
	
}