import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n, ans;
	static boolean[] visit;
	static boolean[] teams;
	static int[] populationArr;
	static List<Integer>[] edges;
	
	public static void main(String[] args) {
		input();
		checkAll();
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}
	
	static void input() {
		n = sc.nextInt();
		populationArr = new int[n + 1];
		edges = new ArrayList[n + 1];
		visit = new boolean[n + 1];
		teams = new boolean[n + 1];
		ans = Integer.MAX_VALUE;
		
		for(int idx = 1; idx <= n; idx++) {
			populationArr[idx] = sc.nextInt();
			edges[idx] = new ArrayList<>();
		}
		
		for(int start = 1; start <= n; start++) {
			int edgeCount = sc.nextInt();
			
			for(int edgeIdx = 0; edgeIdx < edgeCount; edgeIdx++) {
				int end = sc.nextInt();
				edges[start].add(end);
			}
		}
	}
	
	static void checkAll() {
		for(int areaCnt = 1; areaCnt <= n / 2; areaCnt++) {
			divideArea(areaCnt, 1, 0);
		}
	}
	
	static void divideArea(int max, int start, int cnt) {
		if(max == cnt) {
			Arrays.fill(visit, false);
			for(int idx = 1; idx <= n; idx++) {
				if(teams[idx]) {
					connectArea(idx, true);
					break;
				}
			}
			for(int idx = 1; idx <= n; idx++) {
				if(!teams[idx]) {
					connectArea(idx, false);
					break;
				}
			}
			if(checkArea())
				ans = Math.min(ans, calculateDiff());	
			return;
		}
		
		for(int idx = start; idx <= n; idx++) {
			teams[idx] = true;
			divideArea(max, idx + 1, cnt + 1);
			teams[idx] = false;
		}
	}
	
	static void connectArea(int node, boolean team) {
		visit[node] = true;
		
		for(int idx = 0; idx < edges[node].size(); idx++) {
			int end = edges[node].get(idx);
			
			if(teams[end] != team || visit[end]) continue;
			
			connectArea(end, team);
		}
	}
	
	static boolean checkArea() {
		for(int idx = 1; idx <= n; idx++) {
			if(!visit[idx]) return false;
		}
		
		return true;
	}
	
	static int calculateDiff() {
		int aSum = 0;
		int bSum = 0;
		
		for(int idx = 1; idx <= n; idx++) {
			if(teams[idx])
				aSum += populationArr[idx];
			else
				bSum += populationArr[idx];
		}
		
		return Math.abs(aSum - bSum);
	}
}