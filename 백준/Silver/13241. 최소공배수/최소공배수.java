import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static long a;
	static long b;
	static long ans;
	
	public static void main(String[] args) {
		input();
		calculateNum();
		System.out.println(ans);
	}

	static void input() {
		a = sc.nextInt();
		b = sc.nextInt();
		
		if(a < b) swap();
	}

	static void calculateNum() {
		long newA = a;
		long newB = b;
		
		while(newB != 0) {
			long tmp = newA;
			newA = newB;
			newB = tmp % newB;
		}
		
		ans = a / newA * b;
	}
	

	static void swap() {
		long tmp = a;
		a = b;
		b = tmp;
	}
	
}