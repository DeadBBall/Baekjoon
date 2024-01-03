import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static int n;
	static int[] parent;
	static boolean[] visit;
	static StringBuilder ansMaker = new StringBuilder();
	
	public static void main(String[] args) {
		int t = SC.nextInt();
		while(t-- > 0) {
			input();
			findCommonAncestor();
		}
		System.out.print(ansMaker);
	}
	
	static void input() {
		n = SC.nextInt();
		parent = new int[n + 1];
		visit = new boolean[n + 1];
		
		for(int edgeIdx = 0; edgeIdx < n - 1; edgeIdx++) {
			int a = SC.nextInt();
			int b = SC.nextInt();
			
			parent[b] = a;
		}
	}

	static void findCommonAncestor() {
		int a = SC.nextInt();
		int b = SC.nextInt();
		
		while(a != 0) {
			visit[a] = true;
			a = parent[a];
		}
		
		while(b != 0) {
			if(visit[b]) {
				ansMaker.append(b + "\n");
				return;
			}
			b = parent[b];
		}
	}
}