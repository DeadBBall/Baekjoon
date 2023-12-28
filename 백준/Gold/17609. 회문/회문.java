import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static final int PALINDROME = 0;
	static final int SIMILARPALINDROME = 1;
	static final int NOTPALINDROME = 2;
	static String inputStr;
	static StringBuilder ansMaker = new StringBuilder();
	
	public static void main(String[] args) {
		int t = SC.nextInt();
		while(t-- > 0) {
			input();
			judgePalindrome();
		}
		System.out.print(ansMaker);
	}

	static void input() {
		inputStr = SC.next();
	}

	static void judgePalindrome() {
		int left = 0;
		int right = inputStr.length() - 1;
		int flag = 0;
		int savedLeft = 0;
		int savedRight = 0;
		
		while(left < right) {
			char leftChar = inputStr.charAt(left);
			char rightChar = inputStr.charAt(right);
			
			if(leftChar == rightChar) {
				left++;
				right--;
			}
			else {
				if(flag == 2) {
					ansMaker.append(NOTPALINDROME + "\n");
					return;
				}
				else {
					if(flag == 0) {
						savedLeft = left;
						savedRight = right;
						left++;
						flag = 1;
					}
					else if(flag == 1) {
						left = savedLeft;
						right = savedRight;
						right--;
						flag = 2;
					}
				}
			}
			
		}
		
		if(flag >= 1) {
			ansMaker.append(SIMILARPALINDROME + "\n");
			return;
		}
		
		ansMaker.append(PALINDROME + "\n");
	}
}