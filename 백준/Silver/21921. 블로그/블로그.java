import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static int n, x, maxVisitors, count;
	static int[] accumulatedVisitors;
	
	public static void main(String[] args) {
		input();
		checkMaxVisitors();
		System.out.println(maxVisitors == 0 ? "SAD" : maxVisitors + "\n" + count);
	}

	static void input() {
		n = SC.nextInt();
		x = SC.nextInt();
		
		accumulatedVisitors = new int[n + 1];
		for(int day = 1; day <= n; day++) {
			int visitors = SC.nextInt();
			accumulatedVisitors[day] = accumulatedVisitors[day - 1] + visitors;
		}
	}
	
	static void checkMaxVisitors() {
		for(int day = x; day <= n; day++) {
			int visitors = accumulatedVisitors[day] - accumulatedVisitors[day - x];
			
			if(visitors > maxVisitors) {
				maxVisitors = visitors;
				count = 1;
			}
			else if(visitors == maxVisitors) {
				count++;
			}
		}
	}

}