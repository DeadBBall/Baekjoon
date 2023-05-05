import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	static int checkNum(int a, int b) {
		if(a < b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		for(int i = b; i >= 1; i--) {
			if(a % i == 0 && b % i == 0) {
				return i;
			}
		}
		return 1;
	}
	
	public static void main(String[] args) {
		int n = sc.nextInt();
		int start = sc.nextInt();
		for(int i = 0; i < n - 1; i++) {
			int ring = sc.nextInt();
			int num = checkNum(start, ring);
			System.out.println(start / num + "/" + ring / num);
		}
	}
}