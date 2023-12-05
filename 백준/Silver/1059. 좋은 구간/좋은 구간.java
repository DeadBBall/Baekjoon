import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n, l, ans;
	static int[] numbers;
	
	public static void main(String[] args) {
		input();
		searchGoodSection();
		System.out.println(ans);
	}	
	
	static void input() {
		l = sc.nextInt();
		numbers = new int[l];
		
		for(int numIdx = 0; numIdx < l; numIdx++) {
			numbers[numIdx] = sc.nextInt();
		}
		Arrays.sort(numbers);
		
		n = sc.nextInt();	
	}
	
	static void searchGoodSection() {
		for(int numIdx = 0; numIdx < l; numIdx++) {
			int now = numbers[numIdx];
			int next = numIdx == l - 1 ? 0 : numbers[numIdx + 1];
			
			if(now < n && n < next) {
				if(now + 1 == n || next - 1 == n)
					ans = next - now - 2;
				else {
					ans = (next - now - 1) * (next - now - 2) / 2;
					ans -= (next - n - 1) * (next - n - 2) / 2;
					ans -= (n - now - 1) * (n - now - 2) / 2;
				}
				break;
			}
			else if(numIdx == 0 && n < now) {
				if(now - 1 == n)
					ans = n - 1;
				else if(n == 1)
					ans = now - 2;
				else {
					ans = (now - 2) * (now - 1) / 2;
					ans -= (now - n - 1) * (now - n - 2) / 2;
					ans -= (n - 1) * (n - 2) / 2;
				}
				break;
			}			
		}
	}

}