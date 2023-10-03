import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static int[] rank;
	static long ans;
	
	public static void main(String[] args) {
		input();
		calculateDiff();
		System.out.println(ans);
	}

	static void input() {
		n = sc.nextInt();
		rank = new int[n];
		
		for(int idx = 0; idx < n; idx++) {
			rank[idx] = sc.nextInt();
		}
		Arrays.sort(rank);
	}

	static void calculateDiff() {
		for(int idx = 0; idx < n; idx++) {
			ans += Math.abs(rank[idx] - (idx + 1));
		}
	}
	
}