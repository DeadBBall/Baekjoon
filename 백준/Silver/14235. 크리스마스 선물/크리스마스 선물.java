import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static final int CHILD = 0;
	static StringBuilder ansMaker;
	static int n;
	static PriorityQueue<Integer> gifts;

	public static void main(String[] args) {
		input();
		giveGift();
		System.out.println(ansMaker);
	}

	static void input() {
		n = SC.nextInt();
		gifts = new PriorityQueue<>(Collections.reverseOrder());
		ansMaker = new StringBuilder();
	}
	
	static void giveGift() {
		while(n-- > 0) {
			int type = SC.nextInt();
			
			if(type == CHILD) {
				if(gifts.isEmpty())
					ansMaker.append("-1");
				else
					ansMaker.append(gifts.remove());
				ansMaker.append("\n");
			}
			else {
				for(int giftCnt = 0; giftCnt < type; giftCnt++) {
					int gift = SC.nextInt();
					gifts.add(gift);
				}
			}
		}
	}
	
}