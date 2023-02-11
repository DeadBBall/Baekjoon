import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int f;
	static int s;
	static int g;
	static int u;
	static int d;
	static boolean visit[];
	static int ans = -1;
	
	static void checkElv() {
		Queue<int[]> q = new LinkedList<>();
		visit[s] = true;
		q.add(new int[]{s, 0});
		while(!q.isEmpty()) {
			int[] now = q.peek();
			q.poll();
			if(now[0] == g) {
				ans = now[1];
				return;
			}
			visit[now[0]] = true;
			if(now[0] + u <= f && !visit[now[0] + u]) {
				visit[now[0] + u] = true;
				q.add(new int[] {now[0] + u, now[1] + 1});
			}
			if(now[0] - d > 0 && !visit[now[0] - d]) {
				visit[now[0] - d] = true;
				q.add(new int[] {now[0] - d, now[1] + 1});
			}
		}
	}
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		f = sc.nextInt();
		s = sc.nextInt();
		g = sc.nextInt();
		u = sc.nextInt();
		d = sc.nextInt();
		visit = new boolean[f + 1];
	}
	
	public static void main(String[] args) {
		input();
		checkElv();
		if(ans == -1) {
			System.out.println("use the stairs");
		}
		else {
			System.out.println(ans);
		}
	}
}