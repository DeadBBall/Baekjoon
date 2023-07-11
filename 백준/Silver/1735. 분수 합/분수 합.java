import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int denominator;
	static int molecule;
	static int ans;
	
	static void input() {
		int a, b, c, d;
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		denominator = b * d;
		molecule = a * d + b * c;
	}
	
	static void makeIF() {
		int tmp = -1;
		int tmpD = denominator;
		int tmpM = molecule;
		while(tmp != 0) {
			tmp = tmpD % tmpM;
			tmpD = tmpM;
			tmpM = tmp;
		}
		denominator /= tmpD;
		molecule /= tmpD;
	}
	
	public static void main(String[] args) {
		input();
		makeIF();
		System.out.println(molecule + " " + denominator);
	}
}