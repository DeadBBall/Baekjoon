import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static int n, m;
	static List<Edge>[] edges;
	static int[] dists;
	
    public static void main(String[] args) {
    	input();
    	makeDelivery();
    	System.out.println(dists[n]);
    }

    static void input() {
    	n = SC.nextInt();
    	m = SC.nextInt();
    	
    	dists = new int[n + 1];
    	edges = new ArrayList[n + 1];
    	
    	for(int barnIdx = 1; barnIdx <= n; barnIdx++) {
    		edges[barnIdx] = new ArrayList<>();
    		dists[barnIdx] = Integer.MAX_VALUE;
    	}
    	
    	for(int edgeIdx = 0; edgeIdx < m; edgeIdx++) {
    		int barn = SC.nextInt();
    		int barn2 = SC.nextInt();
    		int dist = SC.nextInt();
    		
    		edges[barn].add(new Edge(barn2, dist));
    		edges[barn2].add(new Edge(barn, dist));
    	}
    	
    }
    
    static void makeDelivery() {
    	dists[1] = 0;
    	
    	PriorityQueue<Edge> edgeQueue = new PriorityQueue<>(new Comparator<Edge>() {
    		
    		@Override
    		public int compare(Edge a, Edge b) {
    			return a.dist - b.dist;
    		}
    	});
    	
    	edgeQueue.add(new Edge(1, 0));
    	
    	while(!edgeQueue.isEmpty()) {
    		Edge now = edgeQueue.remove();
    		
    		for(Edge next : edges[now.start]) {
    			if(dists[next.start] > next.dist + dists[now.start]) {
    				dists[next.start] = next.dist + dists[now.start];
    				edgeQueue.add(new Edge(next.start, dists[next.start]));
    			}
    			
    		}
    	}
    	
    }

}

class Edge {
	int start;
	int dist;
	
	public Edge(int start, int dist) {
		this.start = start;
		this.dist = dist;
	}
	
}