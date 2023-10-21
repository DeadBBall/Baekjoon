import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder ansMaker = new StringBuilder();
	static String[] patterns;
	static String word;
	
	public static void main(String[] args) {
		int n = sc.nextInt();
		String pattern = sc.next();
		patterns = pattern.split("\\*");
		while(n-- > 0) {
			input();
			ansMaker.append(checkPattern() ? "DA\n" : "NE\n"); 
		}
		System.out.println(ansMaker);
	}

	static void input() {
		word = sc.next();
	}
	
	static boolean checkPattern() {
		if(patterns[0].length() + patterns[1].length() > word.length()) return false;
		
		for(int idx = 0; idx < patterns[0].length(); idx++) {
			if(word.charAt(idx) != patterns[0].charAt(idx)) return false;
		}
		
		for(int idx = patterns[1].length() - 1; idx >= 0; idx--) {
			if(word.charAt(word.length() + idx - patterns[1].length()) != patterns[1].charAt(idx)) return false;
		}
		return true;
	}
}