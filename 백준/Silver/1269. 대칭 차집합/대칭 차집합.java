import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n, m;
	static Set<Integer> a;
	static int ans;
	
	static void input() {
		n = sc.nextInt();
		m = sc.nextInt();
		a = new HashSet<>();
		for(int i = 0; i < n; i++) {
			a.add(sc.nextInt());
		}
		ans = m + n;
	}
	
	static void checkSet() {
		Iterator<Integer> it = a.iterator();
		int diff = 0;
		for(int i = 0; i < m; i++) {
			if(a.contains(sc.nextInt())) {
				diff++;
			}
		}
		ans -= diff * 2;
	}
	
	public static void main(String[] args) {
		input();
		checkSet();
		System.out.println(ans);
	}
}