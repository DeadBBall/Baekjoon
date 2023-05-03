import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n, m;
	static List<Integer> list;
	static int ans;
	
	static void input() {
		n = sc.nextInt();
		m = sc.nextInt();
		list = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			list.add(i);
		}
	}
	
	static void searchNum() {
		int idx = 0;
		for(int i = 0; i < m; i++) {
			int obj = sc.nextInt();
			idx %= list.size();
			if(list.get(idx) != obj) {
				int objIdx = list.indexOf(obj);
				int diff = Math.abs(objIdx - idx);
				ans += (diff > list.size() - diff ? list.size() - diff : diff);
				idx = objIdx;
			}
			list.remove(idx);
		}
	}
	
	public static void main(String[] args) {
		input();
		searchNum();
		System.out.println(ans);
	}
}