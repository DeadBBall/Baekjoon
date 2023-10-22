import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static StringBuilder ansMaker = new StringBuilder();
	static long a, b, c, d;
	
	public static void main(String[] args) {
		int t = sc.nextInt();
		while(t-- > 0) {
			input();
			cutCake();
		}
		System.out.println(ansMaker);
	}

	static void input() {
		a = sc.nextLong();
		b = sc.nextLong();
		c = sc.nextLong();
		d = sc.nextLong();
	}

	static void cutCake() {
		Long[] lengthArr = new Long[] {a, b, c};
		Arrays.sort(lengthArr, Collections.reverseOrder());
		
		long total = 0;
		
		if(lengthArr[0] + lengthArr[1] - lengthArr[2] * 2 < d) {
			total = lengthArr[0] + lengthArr[1] + lengthArr[2] - d;
			lengthArr[0] = total / 3;
			lengthArr[1] = (total - lengthArr[0]) / 2;
			lengthArr[2] = total - lengthArr[0] - lengthArr[1];
		}
		else {
			if(lengthArr[0] - lengthArr[1] < d) {
				total = lengthArr[0] + lengthArr[1] - d;
				lengthArr[0] = total / 2;
				lengthArr[1] = total - total / 2;
			}
			else
				lengthArr[0] -= d;
		}
		
//		System.out.println(lengthArr[0] + " " + lengthArr[1] + " " + lengthArr[2]);
		ansMaker.append(lengthArr[0] * lengthArr[1] * lengthArr[2] + "\n");
	}
}