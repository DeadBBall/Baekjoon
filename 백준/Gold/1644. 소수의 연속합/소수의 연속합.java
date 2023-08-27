import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int n;
	static boolean[] nums;
	static List<Integer> sums;
	static int ans;
			
	public static void main(String[] args) {
		input();
		searchPrimeNumber();
		calculateSum();
		findPrimeSum();
		System.out.println(ans);
	}

	static void input() {
		n = sc.nextInt();
		nums = new boolean[n + 1];
		sums = new ArrayList<>();
		sums.add(0);
	}
	
	static void searchPrimeNumber() {
		nums[1] = true;
		
		for(int i = 2; i * i <= n; i++) {
			if(nums[i]) continue;
			
			for(int j = i * 2; j <= n; j += i) {
				nums[j] = true;
			}
		}
	}
	
	static void calculateSum() {
		int sum = 0;
		for(int numIdx = 2; numIdx <= n; numIdx++) {
			if(!nums[numIdx]) {
				sum += numIdx;
				sums.add(sum);
			}
		}
	}
	
	static void findPrimeSum() {
		int left = 0;
		int right = 1;
		int size = sums.size();
		
		while(left <= right && left < size && right < size) {
			int sum = sums.get(right) - sums.get(left);
			
			if(sum < n) right++;
			else if(sum > n) left++;
			else {
				ans++;
				left++;
			}
		}
	}
	
}