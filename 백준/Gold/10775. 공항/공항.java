import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static int g, p, ans;
	static int[] gates;
	
	public static void main(String[] args) {
		input();
		dockAirplane();
		System.out.println(ans);
	}

	static void input() {
		g = SC.nextInt();
		p = SC.nextInt();
		gates = new int[g + 1];
		
		for(int gateIdx = 1; gateIdx <= g; gateIdx++) {
			gates[gateIdx] = gateIdx;
		}
	}
	
	static void dockAirplane() {
		for(int airplaneIdx = 0; airplaneIdx < p; airplaneIdx++) {
			int airplane = SC.nextInt();
			
			int nowGate = find(airplane);
			
			if(nowGate == 0) break;
			
			union(nowGate, nowGate - 1);
			ans++;
		}
	}
	
	static int find(int x) {
		if(gates[x] == x) return x;
		
		return gates[x] = find(gates[x]);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y) return;
		
		gates[x] = y;
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
