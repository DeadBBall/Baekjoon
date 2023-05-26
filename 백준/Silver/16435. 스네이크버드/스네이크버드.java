import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n, l;
	static int[] fruit;
	
	static void input() {
		n = sc.nextInt();
		l = sc.nextInt();
		fruit = new int[n];
		for(int i = 0; i < n; i++) {
			fruit[i] = sc.nextInt();
		}
		Arrays.sort(fruit);
	}
	
	static void eat() {
		for(int i = 0; i < n; i++) {
			if(fruit[i] <= l) {
				l++;
			}
		}
	}
	
	public static void main(String[] args) {
		input();
		eat();
		System.out.println(l);
	}
}