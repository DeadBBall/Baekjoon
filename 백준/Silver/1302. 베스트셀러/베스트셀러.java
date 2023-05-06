import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static Map<String, Integer> books = new HashMap<>();

	public static void main(String[] args) {
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String book = sc.next();
			if (books.containsKey(book)) {
				books.put(book, books.get(book) + 1);
			} else {
				books.put(book, 1);
			}
		}
		List<String> list = new ArrayList<>(books.keySet());

		list.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (books.get(o1).compareTo(books.get(o2)) == 0) {
					return o1.compareTo(o2);
				}
				return books.get(o2).compareTo(books.get(o1));
			}
		});
		System.out.println(list.get(0));
	}
}