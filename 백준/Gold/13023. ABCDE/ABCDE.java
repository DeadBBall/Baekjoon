import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static boolean[] visit;
	static int n, m, ans;
	static List<Integer>[] list;
	
	
	static void input() {
		n = sc.nextInt();
		m = sc.nextInt();
		visit = new boolean[n];
		list = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}
	}
	
	static void checkFriends(int start, int sum) {
		if(sum >= 4) {
			ans = sum;
			return;
		}
		for(int j = 0; j < list[start].size(); j++) {
			int end = list[start].get(j);
			if(!visit[end]) {
				visit[end] = true;
				checkFriends(end, sum + 1);
				visit[end] = false;
			}
			if(ans >= 4) {
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		input();
		for(int i = 0; i < n; i++) {
			Arrays.fill(visit, false);
			visit[i] = true;
			checkFriends(i, 0);
			if(ans >= 4) {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
	}
}