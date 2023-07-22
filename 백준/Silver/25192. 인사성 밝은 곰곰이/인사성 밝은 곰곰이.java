import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static Set<String> set;
	static int n;
	static int ans;
	
	static void input() {
		n = sc.nextInt();
		set = new HashSet<>();
	}
	
	static void countEmo() {
		for(int i = 0; i < n; i++) {
			String nowChat = sc.next();
			if(nowChat.equals("ENTER")) {
				set.clear();
			}
			else {
				if(!set.contains(nowChat)) {
					ans++;
					set.add(nowChat);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		input();
		countEmo();
		System.out.println(ans);
	}
	
}