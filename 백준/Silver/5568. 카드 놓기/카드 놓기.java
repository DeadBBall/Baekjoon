import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n, k;
	static int[] numbers;
	static boolean[] visit;
	static Set<Integer> numberSet;
	
	public static void main(String[] args) {
		input();
		pickKNumbers(0, new StringBuilder());
		System.out.println(numberSet.size());
	}	
	
	static void input() {
		n = sc.nextInt();
		k = sc.nextInt();
		numberSet = new HashSet<>();
		visit = new boolean[n];
		
		numbers = new int[n];
		for(int numIdx = 0; numIdx < n; numIdx++) {
			numbers[numIdx] = sc.nextInt();
		}
	}
	
	static void pickKNumbers(int count, StringBuilder number) {
		if(count == k) {
			numberSet.add(Integer.parseInt(number.toString()));
			return;
		}
		
		for(int numIdx = 0; numIdx < n; numIdx++) {
			if(visit[numIdx]) continue;
			
			visit[numIdx] = true;
			number.append(numbers[numIdx]);
			
			pickKNumbers(count + 1, number);
			
			visit[numIdx] = false;
			number.delete(number.length() - String.valueOf(numbers[numIdx]).length(), number.length());
		}
	}

}