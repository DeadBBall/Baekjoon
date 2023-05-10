import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n, m;
	static Set<String> set;
	static int ans;
	
	static void input() {
		n = sc.nextInt();
		m = sc.nextInt();
		set = new HashSet<>();
		for(int i = 0; i < n; i++) {
			set.add(sc.next());
		}
	}

	static void countStr() {
		for(int i = 0; i < m; i++) {
			if(set.contains(sc.next())) {
				ans++;
			}
		}
	}
	
	public static void main(String[] args) {
		input();
		countStr();
		System.out.println(ans);
	}
}