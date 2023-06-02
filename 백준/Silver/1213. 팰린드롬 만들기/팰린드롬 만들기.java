import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static String inputStr;
	static int[] alp = new int[26];
	static int oddIdx = -1;
	
	static void input() {
		inputStr = sc.next();
		for(int i = 0; i < inputStr.length(); i++) {
			alp[inputStr.charAt(i) - 'A']++;
		}
	}
	
	static void makePalindrome() {
		for(int i = 0; i < 26; i++) {
			if(alp[i] % 2 == 1) {
				if(oddIdx != -1) {
					System.out.println("I'm Sorry Hansoo");
					return;
				}
				oddIdx = i;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 26; i++) {
			if(alp[i] >= 2) {
				for(int j = 0; j < alp[i] / 2; j++) {
					sb.append((char)('A' + i));
				}
			}
		}
		String ans = sb.toString();
		if(oddIdx != -1) {
			ans += (char)('A' + oddIdx);			
		}
		ans += sb.reverse().toString();
		System.out.println(ans);
	}
	
	public static void main(String[] args) {
		input();
		makePalindrome();
	}
}