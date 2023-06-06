import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int[] trees;
	static int ans;
	static int n;
	
	static void input() {
		n = sc.nextInt();
		trees = new int[n];
		for(int i = 0; i < n; i++) {
			trees[i] = sc.nextInt();
		}
		Arrays.sort(trees);
	}
	
	static void checkDays() {
		int day = 1;
		for(int i = trees.length - 1; i >= 0; i--) {
			ans = Math.max(ans, day + trees[i]);
			day++;
		}
	}
	
	public static void main(String[] args) {
		input();
		checkDays();
		System.out.println(ans + 1);
	}
}