import java.util.Scanner;
import java.util.Stack;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int n;
	static String inputStr;
	static Stack<Double> stack = new Stack<>();
	static double[] arr;
	
	static void input() {
		n = sc.nextInt();
		inputStr = sc.next();
		arr = new double[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
	}
	
	static void calculate() {
		int strLength = inputStr.length();
		for(int i = 0; i < strLength; i++) {
			char tmpChar = inputStr.charAt(i);
			if(Character.isAlphabetic(tmpChar)) {
				stack.push(arr[tmpChar - 'A']);
			}
			else {
				double a = 0;
				double b = 0;
				double result = 0;
				if(tmpChar == '+') {
					b = stack.pop();
					a = stack.pop();
					result = a + b;
					stack.push(result);
				}
				else if(tmpChar == '-') {
					b = stack.pop();
					a = stack.pop();
					result = a - b;
					stack.push(result);
				}
				else if(tmpChar == '*') {
					b = stack.pop();
					a = stack.pop();
					result = a * b;
					stack.push(result);
				}
				else {
					b = stack.pop();
					a = stack.pop();
					result = a / b;
					stack.push(result);
				}
			}
		}
		System.out.printf("%.2f", Math.round(stack.pop() * 100) / 100.0);
	}

	static void solve() {
		input();
		calculate();
	}

	public static void main(String[] args) {
		solve();
	}
}