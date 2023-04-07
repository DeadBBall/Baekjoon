import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int[] arr;
	static int ans;
	static node[] horse;
	static node end;
	static node start;
	static boolean[] visit;

	static class node {
		int value;
		node next;
		node blue;

		public node(int value) {
			this.value = value;
		}
	}

	static {
		start = new node(0);
		horse = new node[] { start, start, start, start };
		end = new node(0);
		node tenblue = new node(13);
		node center = new node(25);
		node tweblue = new node(22);
		node thrblue = new node(28);
		node fin = new node(40);
		((tenblue.next = new node(16)).next = new node(19)).next = center;
		((tweblue.next = new node(24))).next = center;
		((thrblue.next = new node(27)).next = new node(26)).next = center;
		((center.next = new node(30)).next = new node(35)).next = fin;
		node tmp = start;
		for (int i = 1; i <= 19; i++) {
			if (start.value == 10) {
				start.blue = tenblue;
			} else if (start.value == 20) {
				start.blue = tweblue;
			} else if (start.value == 30) {
				start.blue = thrblue;
			}
			start.next = new node(i * 2);
			start = start.next;
		}
		start.next = fin;
		fin.next = end;
		start = tmp;
	}

	static void input() {
		arr = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt();
		}
	}

	static void play(int cnt, int sum) {
		if (cnt == 10) {
			ans = Math.max(ans, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			node now = horse[i];
			int nowScore = sum;
			boolean flag2 = false;
			if (horse[i].next == null) continue;
			if (horse[i].blue != null) {
				horse[i] = horse[i].blue;
			} else {
				horse[i] = horse[i].next;
			}
			for (int j = 0; j < arr[cnt] - 1; j++) {
				if (horse[i].next == null) {
					play(cnt + 1, nowScore);
					horse[i] = now;
					flag2 = true;
					break;
				}
				horse[i] = horse[i].next;
			}
			nowScore += horse[i].value;
			if (flag2) continue;
			boolean flag = false;
			for (int k = 0; k < 4; k++) {
				if (i == k) continue;
				if (horse[i].equals(horse[k])) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				play(cnt + 1, nowScore);
			}
			horse[i] = now;
		}
	}

	public static void main(String[] args) {
		input();
		play(0, 0);
		System.out.println(ans);
	}
}