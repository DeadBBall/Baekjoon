import java.util.Scanner;


public class Main {

	static Scanner sc = new Scanner(System.in);
	static int x;
	static int up;
	static int down;
	
	static void input() {
		x = sc.nextInt();
	}

	static void searchFraction() {
		int num = 0;
		for(int i = 1; ;i++) {
			if(x <= i * (i + 1) / 2) {
				num = i;
				break;
			}
		}
		up = x - (num - 1) * num / 2;
		down = 1 + num - up;
		if(num % 2 != 0) {
			int tmp = up;
			up = down;
			down = tmp;
		}
	}
	
	public static void main(String[] args) {
		input();
		searchFraction();
		System.out.println(up + "/" + down);
	}
}