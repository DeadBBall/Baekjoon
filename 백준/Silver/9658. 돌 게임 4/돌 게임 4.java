import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static int n;

	public static void main(String[] args) {
		input();
		playGame();
	}

	static void input() {
		n = SC.nextInt();
	}

	static void playGame() {
		System.out.println(n % 7 == 1 || n % 7 == 3 ? "CY" : "SK");
	}

}