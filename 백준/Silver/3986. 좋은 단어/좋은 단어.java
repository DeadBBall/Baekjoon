import java.util.Scanner;
import java.util.Stack;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int ans;
	static String word;
	static Stack<Character> stack;

	static void input() {
		word = sc.next();
		stack = new Stack<>();
	}

	static void checkWord() {
		int wordLen = word.length();
		stack.add(word.charAt(0));
		for (int i = 1; i < wordLen; i++) {
			if (!stack.isEmpty() && stack.peek() == word.charAt(i)) {
				stack.pop();
			} else {
				stack.push(word.charAt(i));
			}
		}
		if (stack.isEmpty()) {
			ans++;
		}
	}

	public static void main(String[] args) {
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			input();
			checkWord();
		}
		System.out.println(ans);
	}
}