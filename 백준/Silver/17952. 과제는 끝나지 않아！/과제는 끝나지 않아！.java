import java.util.Scanner;
import java.util.Stack;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static final int HOMEWORK = 1;
	static Stack<Homework> homeworkStack;
	static int n, ans;
	
	public static void main(String[] args) {
		input();
		doHomework();
		System.out.println(ans);
	}

	static void input() {
		homeworkStack = new Stack<>();
		n = SC.nextInt();
	}

	static void doHomework() {		
		for(int time = 1; time <= n; time++) {
			int type = SC.nextInt();
			
			if(type == HOMEWORK) {
				int score = SC.nextInt();
				int cost = SC.nextInt();
				homeworkStack.add(new Homework(score, cost - 1));
			}
			else if(!homeworkStack.isEmpty()){
				Homework now = homeworkStack.pop();
				now.cost--;
				homeworkStack.add(now);
			}
			if(!homeworkStack.isEmpty() && homeworkStack.peek().cost == 0) {
				ans += homeworkStack.pop().score;
			}
		}
	}
	
}

class Homework {
	int score;
	int cost;
	
	public Homework(int score, int cost) {
		this.score = score;
		this.cost = cost;
	}
}