import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static String str;
	static Set<String> set;
	
	static void input() {
		str = sc.nextLine();
		set = new HashSet<>();
	}
	
	static void countStr() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.length(); i++) {
			sb.setLength(0);
			for(int j = 0; j + i < str.length(); j++) {
				sb.append(str.charAt(i + j));
				set.add(sb.toString());
			}
		}
	}
	
	public static void main(String[] args) {
		input();
		countStr();
		System.out.println(set.size());
	}
}