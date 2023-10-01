import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static final int MAXGAMECOUNT = 1000;
	static int n;
	static boolean[] results;
	
	public static void main(String[] args) {
		input();
		playGame();
		System.out.println(results[n] ? "CY" : "SK");
	}

	static void input() {
		n = sc.nextInt();
		results = new boolean[MAXGAMECOUNT + 1];
		results[2] = true;
	}
	
	static void playGame() {
		for(int stoneCount = 5; stoneCount <= n; stoneCount++) {
			if(!results[stoneCount - 1] && !results[stoneCount - 3] && !results[stoneCount - 4])
				results[stoneCount] = true;
		}
	}
}