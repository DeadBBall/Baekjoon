import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder ansMaker = new StringBuilder();
	static int cnt;
	public static int[] getPi(String pt) {
		int[] pi = new int[pt.length()];

		int j = 0;
		for (int i = 1; i < pt.length(); i++) {
			while (j > 0 && pt.charAt(i) != pt.charAt(j)) {
				j = pi[j - 1];
			}
			if (pt.charAt(i) == pt.charAt(j)) {
				pi[i] = ++j;
			}
		}
		return pi;
	}

	public static void kmp(String text, String pt) {
		int[] pi = getPi(pt);

		int j = 0;
		for (int i = 0; i < text.length(); i++) {
			while (j > 0 && text.charAt(i) != pt.charAt(j))
				j = pi[j - 1];

			if (text.charAt(i) == pt.charAt(j)) {
				if (j == pt.length() - 1) {
					cnt++;
					ansMaker.append(i - pt.length() + 2).append("\n");
					j = pi[j];
				} else {
					j++;
				}
			}
		}
	}

	public static void main(String[] args) {
		String text = sc.nextLine();
		String pattern = sc.nextLine();

		kmp(text, pattern);
		System.out.println(cnt);
		System.out.println(ansMaker);
	}
}