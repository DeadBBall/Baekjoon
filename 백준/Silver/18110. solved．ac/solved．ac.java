import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int[] nums;
	static int minus;
	static int sum;
	
	static void input() throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		nums = new int[n];
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			sum += nums[i];
		}
		Arrays.sort(nums);
		minus = (int) Math.round(((float)n * 0.15));
	}

	static void calculate() {
		for(int i = 0; i < minus; i++) {
			sum -= nums[i];
		}
		for(int i = n - 1; i >= n - minus; i--) {
			sum -= nums[i];
		}
		int ans = (int) Math.round((float)sum / (n - 2 * minus));
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		calculate();
	}
}