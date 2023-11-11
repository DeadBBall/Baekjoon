import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static String target;
	static int n, ans;
	
	public static void main(String[] args) {
		target = sc.next();
		n = sc.nextInt();
		while(n --> 0) {
			checkRing();
		}
		System.out.println(ans);
	}
	
	static void checkRing() {
		String input = sc.next();
		String ring = input + input;
		if(ring.contains(target)) ans++;
	}

}