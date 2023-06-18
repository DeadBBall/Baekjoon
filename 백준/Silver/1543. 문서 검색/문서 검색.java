import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static String a;
	static String b;
	static int ans;
	
	static void input() {
		a = sc.nextLine();
		b = sc.nextLine();
	}

	static void checkStr() {
		for(int i = 0; i < a.length() - b.length() + 1; i++) {
			boolean flag = true;
			for(int j = 0; j < b.length(); j++) {
				if(a.charAt(i + j) != b.charAt(j)) {
					flag = false;
					break;
				}
			}
			if(flag) {
				ans++;
				i += b.length() - 1;
			}
		}
	}
	
	public static void main(String[] args) {
		input();
		checkStr();
		System.out.println(ans);
	}
}