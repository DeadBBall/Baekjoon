import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static int n, ans;
	static Homework[] homeworks;

	public static void main(String[] args) {
		input();
		doHomework();
		System.out.println(ans);
	}

	static void input() {
		n = SC.nextInt();
		homeworks = new Homework[n];

		for (int homeworkIdx = 0; homeworkIdx < n; homeworkIdx++) {
			int deadline = SC.nextInt();
			int cupRamen = SC.nextInt();
			homeworks[homeworkIdx] = new Homework(deadline, cupRamen);
		}

		Arrays.sort(homeworks, new Comparator<Homework>() {
			@Override
			public int compare(Homework a, Homework b) {
				if (a.deadline == b.deadline)
					return b.cupRamen - a.cupRamen;
				return a.deadline - b.deadline;
			}
		});

	}

	static void doHomework() {
		PriorityQueue<Homework> homeworkPQ = new PriorityQueue<>(new Comparator<Homework>() {
			@Override
			public int compare(Homework a, Homework b) {
				return a.cupRamen - b.cupRamen;
			}
		});
		
		for(Homework now : homeworks) {
			if(homeworkPQ.size() < now.deadline)
				homeworkPQ.add(now);
			else {
				if(homeworkPQ.peek().cupRamen < now.cupRamen) {
					homeworkPQ.remove();
					homeworkPQ.add(now);
				}
			}
		}
		
		while(!homeworkPQ.isEmpty()) {
			ans += homeworkPQ.remove().cupRamen;
		}
	}

}

class Homework {
	int deadline;
	int cupRamen;

	public Homework(int deadline, int cupRamen) {
		this.deadline = deadline;
		this.cupRamen = cupRamen;
	}

}