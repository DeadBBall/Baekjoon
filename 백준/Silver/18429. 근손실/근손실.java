import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n, k, ans;
	static int[] kits;
	static boolean[] visit;
	
	public static void main(String[] args) {
		input();
		exercise(500, 0);
		System.out.println(ans);
	}
	
	static void input() {
		n = sc.nextInt();
		k = sc.nextInt();
		visit = new boolean[n];
		kits = new int[n];
		
		for(int kitIdx = 0; kitIdx < n; kitIdx++) {
			kits[kitIdx] = sc.nextInt();
		}
	}
	
	static void exercise(int now, int today) {
		if(today == n) {
			ans++;
			return;
		}
		
		for(int kitIdx = 0; kitIdx < n; kitIdx++) {
			if(visit[kitIdx]) continue;
			
			if(now - k + kits[kitIdx] < 500) continue;
			visit[kitIdx] = true;
			exercise(now - k + kits[kitIdx], today + 1);
			visit[kitIdx] = false;
		}
	}
}
