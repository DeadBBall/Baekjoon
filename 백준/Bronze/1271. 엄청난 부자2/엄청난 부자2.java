import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static BigInteger n;
	static BigInteger m;
	
	public static void main(String[] args) {
		input();
		System.out.println(n.divide(m));
		System.out.println(n.remainder(m));
	}

	static void input() {
		n = sc.nextBigInteger();
		m = sc.nextBigInteger();
	}
	
}