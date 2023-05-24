import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static String[] guitar;
	
	static void input() {
		n = sc.nextInt();
		guitar = new String[n];
		for(int i = 0; i < n; i++) {
			guitar[i] = sc.next();
		}
	}
	
	static void sort() {
		Arrays.sort(guitar, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() != o2.length()) {
					return o1.length() - o2.length();
				}
				else {
					int sumA = 0;
					int sumB = 0;
					for(int i = 0; i < o1.length(); i++) {
						char c = o1.charAt(i);
						if('0' <= c && c <= '9') {
							sumA += c - '0';
						}
					}
					for(int i = 0; i < o2.length(); i++) {
						char c = o2.charAt(i);
						if('0' <= c && c <= '9') {
							sumB += c - '0';
						}
					}
					if(sumA != sumB) {
						return sumA - sumB;
					}
					else {
						return o1.compareTo(o2);
					}
				}
			}
		});
	}

	public static void main(String[] args) {
		input();
		sort();
		for(int i = 0; i < n; i++) {
			System.out.println(guitar[i]);
		}
	}
}