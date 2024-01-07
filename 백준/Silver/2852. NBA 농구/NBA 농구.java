import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static final int AGOAL = 1;
	static final int BGOAL = 2;
	static int n;
	
	public static void main(String[] args) {
		input();
		watchNBA();
	}
	
	static void input() {
		n = SC.nextInt();
	}

	static void watchNBA() {
		int aScore = 0;
		int bScore = 0;
		int time = 0;
		
		int aTime = 0;
		int bTime = 0;
		
		for(int goalIdx = 0; goalIdx < n; goalIdx++) {
			int nowGoal = SC.nextInt();
			String[] inputTime = SC.next().split(":");
			
			int nowTime = Integer.parseInt(inputTime[0])* 60 + Integer.parseInt(inputTime[1]);
			
			if(aScore > bScore)
				aTime += nowTime - time;
			
			else if(aScore < bScore)
				bTime += nowTime - time;
			
			time = nowTime;
			
			if(nowGoal == AGOAL)
				aScore++;
			
			else if(nowGoal == BGOAL)
				bScore++;
		}
		
		int endTime = 48 * 60;
		
		if(aScore > bScore)
			aTime += endTime - time;
		
		else if(aScore < bScore)
			bTime += endTime - time;
		
		System.out.println(changeTimeFormat(aTime));
		System.out.println(changeTimeFormat(bTime));
	}
	
	static String changeTimeFormat(int time) {
		int minute = time / 60;
		int second = time % 60;
		
		StringBuilder timeMaker = new StringBuilder();
		
		timeMaker.append(minute <= 9 ? "0" + minute : minute);
		timeMaker.append(":");
		timeMaker.append(second <= 9 ? "0" + second : second);
		
		return timeMaker.toString();
	}
	
}