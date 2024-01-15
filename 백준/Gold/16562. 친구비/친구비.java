import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static int n, m, k;
	static PriorityQueue<Edge> edges;
	static int[] parents;
	
	public static void main(String[] args) {
		input();
		makeFriendPayment();
	}

	static void input() {
		n = SC.nextInt();
		m = SC.nextInt();
		k = SC.nextInt();
		
		edges = new PriorityQueue<>(new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.cost - o2.cost;
			}
		});
		parents = new int[n + 1];
		
		for(int friendIdx = 1; friendIdx <= n; friendIdx++) {
			int cost = SC.nextInt();
			edges.add(new Edge(0, friendIdx, cost));
			parents[friendIdx] = friendIdx;
		}
		
		for(int edgeIdx = 0; edgeIdx < m; edgeIdx++) {
			int v = SC.nextInt();
			int w = SC.nextInt();
			
			edges.add(new Edge(v, w, 0));
			edges.add(new Edge(w, v, 0));
		}
	}
	
	static void makeFriendPayment() {
		int totalFriendPayment = 0;
		
		while(!edges.isEmpty()) {
			Edge now = edges.remove();
			
			if(isUnion(now.start, now.end)) continue;
			
			else {
				union(now.start, now.end);
				totalFriendPayment += now.cost;
				
				if(totalFriendPayment > k) {
					System.out.println("Oh no");
					return;
				}
			}
		}
		System.out.println(totalFriendPayment);
	}
	
	static int find(int x) {
		if(parents[x] == x) return x;
		
		return parents[x] = find(parents[x]);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(y == x) return;
		
		parents[y] = x;
	}
	
	static boolean isUnion(int x, int y) {
		return find(x) == find(y);
	}
	
}

class Edge {
	int start;
	int end;
	int cost;
	
	public Edge(int start, int end, int cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}
	
}
