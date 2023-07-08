import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n, m, ans;
	static int[] mat;
	
	static void input() {
		n = sc.nextInt();
		m = sc.nextInt();
		mat = new int[n];
		for(int i = 0; i < n; i++) {
			mat[i] = sc.nextInt();
		}
		Arrays.sort(mat);
	}
	
	static void makeArmor() {
		for(int i = 0; i < n; i++) {
			int num = mat[i];
			int start = i + 1;
			int end = n - 1;
			while(start <= end) {
				int mid = (start + end) / 2;
				if(mat[mid] + num > m) {
					end = mid - 1;
				}
				else if(mat[mid] + num < m) {
					start = mid + 1;
				}
				else {
					ans++;
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		input();
		makeArmor();
		System.out.println(ans);
	}
}