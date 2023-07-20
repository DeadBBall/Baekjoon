import java.util.*;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static long[] numbers;
	static int maxCount;
	static long ans;

	static void input() {
		n = sc.nextInt();
		numbers = new long[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = sc.nextLong();
		}
		Arrays.sort(numbers);
		maxCount = 1;
		ans = numbers[0];
	}

	static void countNumbers() {
		int count = 1;
		long now = numbers[0];
		for (int i = 1; i < n; i++) {
			if (now == numbers[i]) {
				count++;
				if (i == n - 1 && maxCount < count) {
					maxCount = count;
					ans = now;
				}
			} else {
				if (maxCount < count) {
					maxCount = count;
					ans = now;
				}
				count = 1;
				now = numbers[i];
			}
		}
	}

	public static void main(String[] args) {
		input();
		countNumbers();
		System.out.println(ans);
	}
}