import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static int[] nums;
	static int ans;
	static int[] sorted;
	static boolean[] visit;
	
	static void input() {
		n = sc.nextInt();
		nums = new int[n];
		visit = new boolean[n];
		sorted = new int[n];
		for(int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
	}
	
	static void sort(int cnt) {
		if(cnt == n) {
			int sum = 0;
			for(int i = 0; i < n - 1; i++) {
				sum += Math.abs(sorted[i] - sorted[i + 1]);
			}
			ans = Math.max(ans, sum);
			return;
		}
		for(int i = 0; i < n; i++) {
			if(visit[i]) {
				continue;
			}
			visit[i] = true;
			sorted[cnt] = nums[i];
			sort(cnt + 1);
			visit[i] = false;
		}
		
	}
	
	public static void main(String[] args) {
		input();
		sort(0);
		System.out.println(ans);
	}
}