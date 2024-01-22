import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static StringBuilder ansMaker = new StringBuilder();
	
	public static void main(String[] args) {
		int p = SC.nextInt();
		while(p-- > 0) {
			lineUp();
		}
		System.out.print(ansMaker);
	}
	
	static void lineUp() {
		int tc = SC.nextInt();
		ansMaker.append(tc + " ");
		
		int ans = 0;
		Student first = new Student(SC.nextInt());
		
		for(int studentIdx = 1; studentIdx < 20; studentIdx++) {
			Student now = new Student(SC.nextInt());
			Student cur = first;
			
			int idx = 0;
			
			while(true) {
				if(cur.height > now.height) {
					if(cur.prev != null) {
						cur.prev.next = now;
						now.prev = cur.prev;
					}
					else {
						first = now;
					}
					
					now.next = cur;
					cur.prev = now;
					ans += studentIdx - idx;
					break;
				}
				else {
					if(cur.next == null) {
						cur.next = now;
						now.prev = cur;
						break;
					}
					idx++;
					cur = cur.next;
				}
			}
			
		}
		ansMaker.append(ans).append("\n");
	}
	
}

class Student {
	Student prev;
	Student next;
	int height;
	
	public Student(int height) {
		this.height = height;
	}
	
}