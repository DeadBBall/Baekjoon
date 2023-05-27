import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static String numStr;
	static int num;
	static int ans;

	static void input() {
		numStr = sc.next();
		for(int i = 0; i < numStr.length(); i++) {
			num += numStr.charAt(i) - '0';
		}
		if(numStr.length() != 1) {
			ans++;
		}
	}

	static void checkNum() {
		while(true) {
			if(num < 10) {
				return;
			}
			numStr = String.valueOf(num);
			num = 0;
			for(int i = 0; i < numStr.length(); i++) {
				num += numStr.charAt(i) - '0';
			}
			ans++;
		}
	}
	
	public static void main(String[] args) {
		input();
		checkNum();
		System.out.println(ans);
		System.out.println(num % 3 == 0 ? "YES" : "NO");
	}
}