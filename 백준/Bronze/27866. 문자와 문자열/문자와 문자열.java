import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static String str;
	static int n;
	
	static void input() {
		str = sc.next();
		n = sc.nextInt();
	}
	
	public static void main(String[] args) {
		input();
		System.out.println(str.charAt(n - 1));
	}
}