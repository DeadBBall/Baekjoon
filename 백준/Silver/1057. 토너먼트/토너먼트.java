import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int total, jm, hs; 
	
	static void input() {
		total = sc.nextInt();
		jm = sc.nextInt();
		hs = sc.nextInt();
	}
	
	static void vs() {
		int ans = 0;
		while(jm != hs) {
			jm = jm / 2 + jm % 2;
			hs = hs / 2 + hs % 2;
			ans++;
		}
		System.out.println(ans);
	}
	
	public static void main(String[] args) {
		input();
		vs();
	}
}