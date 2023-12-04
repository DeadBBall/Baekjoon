import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder ansMaker = new StringBuilder();
	static String word;
	static List<String> numbers = new ArrayList<>();
	
	public static void main(String[] args) {
		int n = sc.nextInt();
		while(n-- > 0) {
			input();
			doHomework();
		}
		sortNumbers();
		printAnswer();
	}	
	
	static void input() {
		word = sc.next();
	}

	static void doHomework() {
		StringBuilder numberMaker = new StringBuilder();
		for(int wordIdx = 0; wordIdx < word.length(); wordIdx++) {
			char now = word.charAt(wordIdx);
			
			if(now >= '0' && now <= '9') {
				numberMaker.append(now);
				if(wordIdx == word.length() - 1)
					deleteUnnecessaryZero(numberMaker);
			}
			
			else {
				if(numberMaker.length() != 0) {
					deleteUnnecessaryZero(numberMaker);
					numberMaker.setLength(0);
				}
			}
		}
	}
	
	static void deleteUnnecessaryZero(StringBuilder numberMaker) {
		while(numberMaker.length() > 1) {
			if(numberMaker.charAt(0) == '0')
				numberMaker.deleteCharAt(0);
			else break;
		}
		numbers.add(numberMaker.toString());
	}
	
	static void sortNumbers() {
		numbers.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				return o1.length() - o2.length();
			}
		});
	}
	
	static void printAnswer() {
		for(String number : numbers) {
			ansMaker.append(number + "\n");
		}
		System.out.print(ansMaker);
	}
}