import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n, m;
	static long ans;
	static PriorityQueue<Long> pq;
	
	static void input() {
		n = sc.nextInt();
		m = sc.nextInt();
		pq = new PriorityQueue<>();
		for(int i = 0; i < n; i++) {
			pq.add(sc.nextLong());
		}
	}
	
	static void fusion() {
		for(int i = 0; i < m; i++) {
			Long a = pq.remove();
			Long b = pq.remove();
			pq.add(a + b);
			pq.add(a + b);
		}
		while(!pq.isEmpty()) {
			ans += pq.remove();
		}
	}
	
	public static void main(String[] args) {
		input();
		fusion();
		System.out.println(ans);
	}
}