import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n, s;
	static int[] nums;
	static int ans;
	
	static void input() {
		n = sc.nextInt();
		s = sc.nextInt();
		nums = new int[n];
		for(int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
	}

	static void makeSequence(int idx, int sum, int cnt) {
		if(idx == n) {
			if(cnt >= 1 && sum == s) {
				ans++;
			}
			return;
		}
		makeSequence(idx + 1, sum + nums[idx], cnt + 1);
		makeSequence(idx + 1, sum, cnt);
	}
	
	public static void main(String[] args) {
		input();
		makeSequence(0, 0, 0);
		System.out.println(ans);
	}
}