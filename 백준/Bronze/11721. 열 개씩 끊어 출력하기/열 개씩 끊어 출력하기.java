import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static String inputStr;
	
	static void input() {
		inputStr = sc.nextLine();
	}

	static void printStr() {
		int n = inputStr.length();
		for(int i = 0; i < n; i++) {
			System.out.print(inputStr.charAt(i));
			if(i % 10 == 9) {
				System.out.println();
			}
		}
	}
	
	static void solve() {
		input();
		printStr();
	}

	public static void main(String[] args) {
		solve();
	}
}
