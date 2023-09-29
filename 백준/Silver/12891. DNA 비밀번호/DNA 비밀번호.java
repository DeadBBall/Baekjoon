import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static final int A = 0;
	static final int C = 1;
	static final int G = 2;
	static final int T = 3;
	static int s;
	static int p;
	static String dna;
	static int a, c, g, t;
	static int ans;
	static int[][] sum;

	public static void main(String[] args) {
		input();
		countPassword();
		System.out.println(ans);
	}

	static void input() {
		s = sc.nextInt();
		p = sc.nextInt();
		sum = new int[s + 1][4];

		dna = sc.next();
		a = sc.nextInt();
		c = sc.nextInt();
		g = sc.nextInt();
		t = sc.nextInt();
	}

	static void countPassword() {
		for (int dnaIdx = 1; dnaIdx <= s; dnaIdx++) {
			char nowDna = dna.charAt(dnaIdx - 1);
			switch (nowDna) {
			case 'A':
				sum[dnaIdx][A]++;
				break;
			case 'C':
				sum[dnaIdx][C]++;
				break;
			case 'G':
				sum[dnaIdx][G]++;
				break;
			default:
				sum[dnaIdx][T]++;
				break;
			}
			for (int idx = 0; idx < 4; idx++) {
				sum[dnaIdx][idx] += sum[dnaIdx - 1][idx];
			}
		}

		for (int dnaIdx = 1; dnaIdx <= s - p + 1; dnaIdx++) {
			int end = dnaIdx + p - 1;
			int start = end - p;
			if(checkPassword(start, end)) ans++;
		}

	}
	
	static boolean checkPassword(int start, int end) {
		return sum[end][A] - sum[start][A] >= a && sum[end][C] - sum[start][C] >= c
				&& sum[end][G] - sum[start][G] >= g && sum[end][T] - sum[start][T] >= t;
	}
}