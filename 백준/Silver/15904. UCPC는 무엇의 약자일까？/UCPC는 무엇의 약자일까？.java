import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static String str;
	static boolean u, c, p, c2;
	
	static void input() {
		str = sc.nextLine();
	}

	static void searchUCPC() {
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'C' && p) {
				c2 = true;
				break;
			}
			else if(str.charAt(i) == 'U') {
				u = true;
			}
			else if(str.charAt(i) == 'C' && u) {
				c = true;
			}
			else if(str.charAt(i) == 'P' && c) {
				p = true;
			}
		}
		if(c2) {
			System.out.println("I love UCPC");
		}
		else {
			System.out.println("I hate UCPC");
		}
	}
	
	public static void main(String[] args) {
		input();
		searchUCPC();
	}
}