import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static int[] area;
	static int budget;
	static int max;
	static int min;
	static int ans;
	
	static void input() {
		n = sc.nextInt();
		area = new int[n];
		for(int i = 0; i < n; i++) {
			area[i] = sc.nextInt();
			max = Math.max(max, area[i]);
		}
		budget = sc.nextInt();
		min = budget / n;
	}
	
	static int check(int num) {
		int sum = 0;
		for(int i = 0; i < n; i++) {
			if(area[i] > num) {
				sum += num;
			}
			else {
				sum += area[i];
			}
		}
		return sum;
	}
	
	static void allocate() {
		while(min <= max) {
			int mid = (min + max) / 2;
			int sum = check(mid);
			if(sum == budget) {
				ans = mid;
				return;
			}
			else if(sum < budget) {
				min = mid + 1;
				ans = mid;
			}
			else {
				max = mid - 1;
			}
		}
	}
	
	public static void main(String[] args) {
		input();
		allocate();
		System.out.println(ans);
	}
}