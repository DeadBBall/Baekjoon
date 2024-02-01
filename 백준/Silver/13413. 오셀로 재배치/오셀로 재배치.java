import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static int n;
	static String origin, target;
	static StringBuilder ansMaker = new StringBuilder();

	public static void main(String[] args) {
		int t = SC.nextInt();
		while (t-- > 0) {
			input();
			rearrangeOthello();
		}
		System.out.println(ansMaker);
	}

	static void input() {
		n = SC.nextInt();
		origin = SC.next();
		target = SC.next();
	}

	static void rearrangeOthello() {
		int diffBCnt = 0;
		int diffWCnt = 0;
		
		for(int othelloIdx = 0; othelloIdx < n; othelloIdx++) {
			char originChar = origin.charAt(othelloIdx);
			char targetChar = target.charAt(othelloIdx);
			
			if(originChar == targetChar) continue;
			
			if(originChar == 'B') diffBCnt++;
			
			else diffWCnt++;
		}
		ansMaker.append(diffBCnt >= diffWCnt ? diffBCnt : diffWCnt).append("\n");
	}
	
}