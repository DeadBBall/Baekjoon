import java.util.Scanner;

class Main {

	static Scanner sc = new Scanner(System.in);
	static String inputStr;
	static String ans;
	
	public static void main(String[] args) {
		input();
		searchWord();
		System.out.println(ans);
	}
	
	static void input() {
		inputStr = sc.next();
	}
	
	static void searchWord() {

		for(int first = 0; first < inputStr.length() - 2; first++) {
			
			for(int second = first + 1; second < inputStr.length() - 1; second++) {
				
				StringBuilder a = new StringBuilder(inputStr.substring(0, first + 1));
				StringBuilder b = new StringBuilder(inputStr.substring(first + 1, second + 1));
				StringBuilder c = new StringBuilder(inputStr.substring(second + 1));
				
				String newWord = a.reverse().toString() + b.reverse().toString() + c.reverse().toString();
                
				if(ans == null) ans = newWord;
				
				if(ans.compareTo(newWord) > 0) ans = newWord;
				
			}
			
		}
	}
	
}