import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static StringBuilder ansMaker = new StringBuilder();
	
	public static void main(String[] args) {
		int t = sc.nextInt();
		while(t-- > 0) {
			input();
			countZero();
		}
		System.out.print(ansMaker);
	}
	
	static void input() {
		n = sc.nextInt();
	}
	
	static void countZero() {
		int two = countTwo(n);
		int five = countFive(n);
		
		ansMaker.append(two > five ? five : two).append("\n");
	}
	
	static int countFive(int num) {
		int count = 0;
		while(num > 0) {
			count += num / 5;
			num /= 5;
		}
		return count;
	}

	static int countTwo(int num) {
		int count = 0;
		while(num > 0) {
			count += num / 2;
			num /= 2;
		}
		return count;
	}

}