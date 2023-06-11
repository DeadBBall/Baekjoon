import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n, x;
	static int[] board;
	static int ans;
	
	static void input() {
		n = sc.nextInt();
		board = new int[n];
		for(int i = 0; i < n; i++) {
			board[i] = sc.nextInt();
		}
		x = sc.nextInt();
	}
	
	static void sumNum() {
		Arrays.sort(board);
		int left = 0;
		int right = n - 1;
		while(left < right) {
			int sum = board[left] + board[right];
			if(sum == x) {
				ans++;
				left++;
				right--;
			}
			else if(sum > x) {
				right--;
			}
			else {
				left++;
			}
		}
	}


	public static void main(String[] args) {
		input();
		sumNum();
		System.out.println(ans);
	}
}