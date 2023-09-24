import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static final int A = 0;
	static final int C = 1;
	static final int G = 2;
	static final int T = 3;
	static int n;
	static int m;
	static String[] dnaArray;
	static int[][] distanceSum;

	public static void main(String[] args) {
		input();
		countDNA();
		makeDNA();
	}

	static void input() {
		n = sc.nextInt();
		m = sc.nextInt();
		dnaArray = new String[n];
		distanceSum = new int[m][4];

		for (int dnaIdx = 0; dnaIdx < n; dnaIdx++) {
			dnaArray[dnaIdx] = sc.next();
		}
		
		Arrays.sort(dnaArray);
		
		for(int strIdx = 0; strIdx < m; strIdx++) {
			Arrays.fill(distanceSum[strIdx], n);
		}
	}

	static void countDNA() {
		for (int dnaIdx = 0; dnaIdx < n; dnaIdx++) {
			String nowDNA = dnaArray[dnaIdx];
			for (int strIdx = 0; strIdx < m; strIdx++) {
				switch (nowDNA.charAt(strIdx)) {
				case 'A':
					distanceSum[strIdx][A]--;
					break;
				case 'C':
					distanceSum[strIdx][C]--;
					break;
				case 'G':
					distanceSum[strIdx][G]--;
					break;
				default:
					distanceSum[strIdx][T]--;
					break;
				}
			}
		}
	}

	static void makeDNA() {
		StringBuilder dnaMaker = new StringBuilder();
		int totalSum = 0;
		
		for(int strIdx = 0; strIdx < m; strIdx++) {
			int minSum = Integer.MAX_VALUE;
			char dna = 0;
			
			for(int dnaIdx = 0; dnaIdx < 4; dnaIdx++) {
				if(minSum > distanceSum[strIdx][dnaIdx]) {
					minSum = distanceSum[strIdx][dnaIdx];
					switch (dnaIdx) {
					case A:
						dna = 'A';
						break;
					case C:
						dna = 'C';
						break;
					case G:
						dna = 'G';
						break;
					default:
						dna = 'T';
						break;
					}
				}
			}
			dnaMaker.append(dna);
			totalSum += minSum;
		}
		System.out.println(dnaMaker);
		System.out.println(totalSum);
	}
}