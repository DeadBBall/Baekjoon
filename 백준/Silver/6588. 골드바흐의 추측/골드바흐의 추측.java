import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
 
public class Main {
	
	static int n;
	static boolean[]primeNumArr = new boolean[1000001];
	
	static void findPrimeNum() {
		for(int i = 3; i <= 1000; i += 2) {
			if(primeNumArr[i]) {
				continue;
			}
			for(int j = i * i; j <= 1000000; j += i) {
				primeNumArr[j] = true;
			}
		}
	}
	
	static void solve() {
		boolean flag = false;
		for(int i = 3; i <= n / 2; i += 2) {
			if(!primeNumArr[i] && !primeNumArr[n - i]) {
				System.out.println(n + " = " + i + " + " + (n - i));
				flag = true;
				break;
			}
		}
		if(!flag) {
			System.out.println("Goldbach's conjecture is wrong.");
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		findPrimeNum();
		while(true) {
			n = Integer.parseInt(br.readLine());
			if(n == 0) {
				return;
			}
			solve();
		}
	}
}