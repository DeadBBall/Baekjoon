import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static int n, m;
	static List<Integer>[] edges;
	static StringBuilder ansMaker = new StringBuilder();
	
	public static void main(String[] args) {
		int caseCount = 1;
		while(true) {
			input();
			if(n == 0) break;
			ansMaker.append("Case " + caseCount++ + ": ");
			countTree();
		}
		System.out.print(ansMaker);
	}

	static void input() {
		n = SC.nextInt();
		m = SC.nextInt();
		
		if(n == 0) return;
	
		edges = new ArrayList[n + 1];
		
		for(int node = 1; node <= n; node++) {
			edges[node] = new ArrayList<>();
		}
		
		while(m-- > 0) {
			int node1 = SC.nextInt();
			int node2 = SC.nextInt();
			
			edges[node1].add(node2);
			edges[node2].add(node1);
		}
		
	}
	
	static void countTree() {
		int treeCount = 0;
		boolean[] visit = new boolean[n + 1];
		
		for(int node = 1; node <= n; node++) {
			if(visit[node]) continue;
			
			if(isTree(visit, node)) treeCount++;
		}
		
		if(treeCount == 0) {
			ansMaker.append("No trees.");
		}
		else if(treeCount == 1) {
			ansMaker.append("There is one tree.");
		}
		else {
			ansMaker.append("A forest of " + treeCount +" trees.");
		}
		ansMaker.append("\n");
	}
	
	static boolean isTree(boolean[] visit, int start) {
		Queue<Integer> nodeQueue = new LinkedList<>();
		nodeQueue.add(start);
		visit[start] = true;
		
		while(!nodeQueue.isEmpty()) {
			int now = nodeQueue.remove();

			for(int end : edges[now]) {
				if(visit[end]) return false;
				
				visit[end] = true;
				
				nodeQueue.add(end);
				
				for(int idx = 0; idx < edges[end].size(); idx++) {
					if(edges[end].get(idx) == now) {
						edges[end].remove(idx);
						break;
					}
				}
			}
		}
		
		return true;
	}
	
}