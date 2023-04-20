import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static boolean[] visit;
	static String[] sign;
	static String minNum;
	static String maxNum;
	static boolean flag;
	static int[] arr;

	static void input() {
		n = sc.nextInt();
		sc.nextLine();
		visit = new boolean[10];
		arr = new int[n + 1];
		sign = sc.nextLine().split(" ");
	}

	static void makeNum(int cnt, int num) {
		if (cnt == n + 1) {
			if (num == 1) {
				minNum = "";
				for (int i = 0; i <= n; i++) {
					minNum += String.valueOf(arr[i]);
				}
			}

			else {
				maxNum = "";
				for (int i = 0; i <= n; i++) {
					maxNum += String.valueOf(arr[i]);
				}
			}
			flag = true;
			return;
		}

		if (num == 1) {
			for (int i = 0; i <= 9; i++) {
				if (visit[i]) {
					continue;
				}
				if (cnt != 0) {
					if (arr[cnt - 1] > i && sign[cnt - 1].charAt(0) == '<') {
						continue;
					}
					if (arr[cnt - 1] < i && sign[cnt - 1].charAt(0) == '>') {
						continue;
					}
				}
				visit[i] = true;
				arr[cnt] = i;
				makeNum(cnt + 1, num);
				visit[i] = false;
				if (flag) {
					return;
				}
			}
		}
		else {
			for (int i = 9; i >= 0; i--) {
				if (visit[i]) {
					continue;
				}
				if (cnt != 0) {
					if (arr[cnt - 1] > i && sign[cnt - 1].charAt(0) == '<') {
						continue;
					}
					if (arr[cnt - 1] < i && sign[cnt - 1].charAt(0) == '>') {
						continue;
					}
				}
				visit[i] = true;
				arr[cnt] = i;
				makeNum(cnt + 1, num);
				visit[i] = false;
				if (flag) {
					return;
				}
			}
		}
	}

	public static void main(String[] args) {
		input();
		makeNum(0, 0);
		flag = false;
		Arrays.fill(visit, false);
		makeNum(0, 1);
		System.out.println(maxNum);
		System.out.println(minNum);
	}
}