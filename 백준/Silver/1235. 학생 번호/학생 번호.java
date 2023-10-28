import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n, ans;
	static String[] students;
	static int numberLength;
	
	public static void main(String[] args) {
		input();
		checkNumber();
		System.out.println(ans);
	}

	static void input() {
		n = sc.nextInt();
		students = new String[n];
		for(int sIdx = 0; sIdx < n; sIdx++) {
			students[sIdx] = sc.next();
		}
		numberLength = students[0].length();
	}
	
	static void checkNumber() {
		Set<String> studentSet = new HashSet<>();
		for(int start = numberLength - 1; start >= 0; start--) {
			boolean isDuplicated = false;
			studentSet.clear();
			
			for(int sIdx = 0; sIdx < n; sIdx++) {
				String nowNumber = students[sIdx].substring(start, numberLength);
				
				if(studentSet.contains(nowNumber)) {
					isDuplicated = true;
					break;
				}
				else studentSet.add(nowNumber);
			}
			
			if(!isDuplicated) {
				ans = numberLength - start;
				return;
			}
		}
	}

}