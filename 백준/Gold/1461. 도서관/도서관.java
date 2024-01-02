import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static int n, m, ans;
	static List<Integer> books;
	
	public static void main(String[] args) {
		input();
		arrangeBooks();
		System.out.println(ans);
	}
	
	static void input() {
		n = SC.nextInt();
		m = SC.nextInt();
		books = new ArrayList<>();
		
		for(int bookIdx = 0; bookIdx < n; bookIdx++) {
			int book = SC.nextInt();
			books.add(book);
		}

		Collections.sort(books);
	}
	
	static void arrangeBooks() {
		boolean last = true;
		while(!books.isEmpty()) {
			int left = books.get(0);
			int right = books.get(books.size() - 1);
			
			if(Math.abs(left) > Math.abs(right)) {
				ans += Math.abs(left) * 2;
				int prev = left;
				
				for(int bookCnt = 0; bookCnt < m && books.size() > 0; bookCnt++) {
					if(prev * books.get(0) < 0) break;
					
					prev = books.remove(0);
				}
			}
			else {
				ans += Math.abs(right) * 2;
				int prev = right;
				
				for(int bookCnt = 0; bookCnt < m && books.size() > 0; bookCnt++) {
					if(prev * books.get(books.size() - 1) < 0) break;
					
					prev = books.remove(books.size() - 1);
				}
			}
			
			if(last) {
				last = false;
				ans /= 2;
			}
		}
	}
}