import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static int[] weights;
	static int ans;
	
	public static void main(String[] args) {
		input();
		checkWeight();
		System.out.println(ans);
	}

	static void input() {
		n = sc.nextInt();
		weights= new int[n];
		
		for(int idx = 0; idx < n; idx++) {
			weights[idx] = sc.nextInt();
		}
		Arrays.sort(weights);
	}
	
	static void checkWeight() {
		int sum = 0;
		
		for(int idx = 0; idx < n; idx++) {
			if(sum + 1 < weights[idx]) break;
			
			sum += weights[idx];
		}
		ans = sum + 1;
	}
}