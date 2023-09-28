import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static int[] houses;
	
	public static void main(String[] args) {
		input();
		System.out.println(houses[(n - 1)/ 2]);
	}

	static void input() {
		n = sc.nextInt();
		houses = new int[n];
		for(int houseIdx = 0; houseIdx < n; houseIdx++) {
			houses[houseIdx] = sc.nextInt();
		}
		Arrays.sort(houses);
	}
}