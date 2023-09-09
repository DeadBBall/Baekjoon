import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static PriorityQueue<Integer> numPQ;
	static int ans;
	
	public static void main(String[] args) {
		input();
		searchNum();
		System.out.println(ans);
	}
	
	static void input() {
		n = sc.nextInt();
		numPQ = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		});
		
		for(int idx = 0; idx < n * n; idx++) {
			numPQ.add(sc.nextInt());
		}
	}
	
	static void searchNum() {
		for(int i = 0; i < n - 1; i++) {
			numPQ.remove();
		}
		ans = numPQ.remove();
	}
}
