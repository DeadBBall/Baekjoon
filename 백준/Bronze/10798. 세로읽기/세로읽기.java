import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static String[] board = new String[5];
	static StringBuilder ans;

	static void input() {
		for (int i = 0; i < 5; i++) {
			board[i] = sc.next();
		}
		ans = new StringBuilder();
	}

	static void read() {
		for (int x = 0; x < 15; x++) {
			for (int y = 0; y < 5; y++) {
				if(board[y].length() >= x + 1) {
					ans.append(board[y].charAt(x));					
				}
			}
		}
	}

	public static void main(String[] args) {
		input();
		read();
		System.out.println(ans);
	}
}