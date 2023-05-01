import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int ans;
	static Stack<Character> s;

	static void inputAndCalc() {
		s = new Stack<>();
		String inputStr = sc.next();
		int len = inputStr.length();
		int num = 1;
		for (int i = 0; i < len; i++) {
			Character c = inputStr.charAt(i);
			switch (c) {
			case '(':
				s.add(c);
				num *= 2;
				break;
			case ')':
				if(s.isEmpty() || s.peek() != '(') {
					ans = 0;
					return;
				}
				else if(inputStr.charAt(i - 1) == '(') {
					ans += num;
				}
				s.pop();
				num /= 2;
				break;
			case '[':
				s.add(c);
				num *= 3;
				break;
			case ']':
				if(s.isEmpty() || s.peek() != '[') {
					ans = 0;
					return;
				}
				else if(inputStr.charAt(i - 1) == '[') {
					ans += num;
				}
				s.pop();
				num /= 3;
				break;
			}
		}
	}

	public static void main(String[] args) {
		inputAndCalc();
		System.out.println(!s.isEmpty() ? 0 : ans);
	}
}