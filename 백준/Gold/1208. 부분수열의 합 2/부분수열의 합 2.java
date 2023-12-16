import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static int[] numbers;

	static int n, s;
	static long ans;

	public static void main(String[] args) {
		input();
		searchS();
		System.out.println(ans);
	}

	static void input() {
		n = SC.nextInt();
		s = SC.nextInt();
		numbers = new int[n];

		for (int numIdx = 0; numIdx < n; numIdx++) {
			numbers[numIdx] = SC.nextInt();
		}

	}

	static void searchS() {
		List<Integer> aSequences = new ArrayList<>();
		List<Integer> bSequences = new ArrayList<>();

		makeNumberOfCases(aSequences, 0, n / 2, 0);
		makeNumberOfCases(bSequences, n / 2 + 1, n - 1, 0);

		Collections.sort(aSequences);
		Collections.sort(bSequences);

		int left = 0;
		int right = bSequences.size() - 1;

		while (left < aSequences.size() && right > -1) {
			long aCount = 0;
			long bCount = 0;

			int nowA = aSequences.get(left);
			int nowB = bSequences.get(right);
			int sum = nowA + nowB;

			if (sum == s) {

				while (right > -1 && bSequences.get(right) == nowB) {
					right--;
					bCount++;
				}
				
				while(left < aSequences.size() && aSequences.get(left) == nowA) {
					left++;
					aCount++;
				}
				
				ans += aCount * bCount;
			}
			
			else if(sum > s) right--;
			
			else left++;
		}
		
		if(s == 0) ans--;
	}

	static void makeNumberOfCases(List<Integer> sequences, int now, int end, int sum) {
		if (now - 1 == end) {
			sequences.add(sum);
			return;
		}

		makeNumberOfCases(sequences, now + 1, end, sum + numbers[now]);
		makeNumberOfCases(sequences, now + 1, end, sum);
	}

}