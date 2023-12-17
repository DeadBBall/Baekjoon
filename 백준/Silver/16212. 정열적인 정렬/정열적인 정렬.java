import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static StringBuilder ansMaker;
	static int n;
	static int[] numbers;

	public static void main(String[] args) {
		input();
		Arrays.sort(numbers);
		printAns();
	}

	static void input() {
		n = SC.nextInt();
		numbers = new int[n];
		ansMaker = new StringBuilder();
		
		for(int numIdx = 0; numIdx < n; numIdx++) {
			numbers[numIdx] = SC.nextInt();
		}

	}
	
	static void printAns() {
		for(int numIdx = 0; numIdx < n; numIdx++) {
			ansMaker.append(numbers[numIdx] + " ");
		}
		System.out.println(ansMaker);
	}

}