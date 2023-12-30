import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static int n, d, ans;
	
	public static void main(String[] args) {
		input();
		countFrequency();
		System.out.println(ans);
	}

	static void input() {
		n = SC.nextInt();
		d = SC.nextInt();
	}
	
	static void countFrequency() {
		for(int num = 1; num <= n; num++) {
			String number = String.valueOf(num);
			
			for(int idx = 0; idx < number.length(); idx++) {
				
				if(number.charAt(idx) - '0' == d) ans++;
			}
		}
	}

}