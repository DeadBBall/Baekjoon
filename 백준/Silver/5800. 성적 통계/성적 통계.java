import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int k;
	static int n;
	static int[] scores;
	static int diff;
	
	static void input() {
		n = sc.nextInt();
		scores = new int[n];
		diff = 0;
		for(int i = 0; i < n; i++) {
			scores[i] = sc.nextInt();
		}
		Arrays.sort(scores);
		for(int i = 1; i < n; i++) {
			int tmpDiff = scores[i] - scores[i - 1];
			diff = Math.max(tmpDiff, diff);
		}
	}

	public static void main(String[] args) {
		k = sc.nextInt();
		for(int i = 0; i < k; i++) {
			input();
			System.out.println("Class " + (i + 1));
			System.out.println("Max " + scores[n - 1] + ", Min " + scores[0] + ", Largest gap " + diff);
		}
	}
}