import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int a, b, m;
		int num10 = 0;
		List<Integer> ans = new ArrayList<>();
		a = sc.nextInt();
		b = sc.nextInt();
		m = sc.nextInt();
		for(int i = 1; i <= m; i++) {
			num10 += (int)Math.pow(a, m - i) * sc.nextInt();
		}
		while(num10 != 0) {
			ans.add(num10 % b);
			num10 /= b;
		}
		for(int i = ans.size() - 1; i >= 0; i--) {
			System.out.print(ans.get(i) + " ");
		}
	}
}