import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n, k;
	static String number;
	static StringBuilder ansMaker;
	
	public static void main(String[] args) {
		input();
		makeMaxNumber();
		System.out.println(ansMaker);
	}

	static void input() {
		n = sc.nextInt();
		k = sc.nextInt();
		number = sc.next();
		ansMaker = new StringBuilder();
	}
	
	static void makeMaxNumber() {
		Stack<Character> numStack = new Stack<>();
		numStack.push(number.charAt(0));
		
		int idx = 1;
		while(idx < n) {
			if(idx - numStack.size() != k && numStack.peek() <= number.charAt(idx)) {
				while(!numStack.isEmpty() && idx - numStack.size() != k && numStack.peek() < number.charAt(idx)) {
					numStack.pop();
				}
			}
			numStack.push(number.charAt(idx));
			idx++;
		}
		while(numStack.size() > n - k) {
			numStack.pop();
		}
		
		while(!numStack.isEmpty()) {
			ansMaker.insert(0, numStack.pop());
		}
	}

}