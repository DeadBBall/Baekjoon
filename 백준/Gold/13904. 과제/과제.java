import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static int n, lastday, ans;
	static PriorityQueue<Homework> homeworkPQ;
	static int[] days;

	public static void main(String[] args) {
		input();
		doHomework();
		System.out.println(ans);
	}

	static void input() {
		homeworkPQ = new PriorityQueue<>(new Comparator<Homework>() {
			@Override
			public int compare(Homework a, Homework b) {
				if (a.score == b.score)
					return b.deadline - a.deadline;
				return b.score - a.score;
			}
		});

		n = SC.nextInt();

		for (int homeworkIdx = 0; homeworkIdx < n; homeworkIdx++) {
			int deadline = SC.nextInt();
			int score = SC.nextInt();

			homeworkPQ.add(new Homework(deadline, score));

			lastday = Math.max(deadline, lastday);
		}

		days = new int[lastday + 1];

	}

	static void doHomework() {
		for (int homeworkIdx = 0; homeworkIdx < n; homeworkIdx++) {
			Homework now = homeworkPQ.remove();

			int today = now.deadline;

			while (days[today] != 0) {
				today--;
			}

			if (today != 0)
				days[today] = now.score;
		}

		for (int score : days) {
			ans += score;
		}

	}
}

class Homework {
	int deadline;
	int score;

	public Homework(int deadline, int score) {
		this.deadline = deadline;
		this.score = score;
	}

}
