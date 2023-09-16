import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static Deque<Balloon> balloons;
	static StringBuilder ansMaker;
	
	public static void main(String[] args) {
		input();
		burstBalloons();
		System.out.println(ansMaker);
	}
	
	static void input() {
		n = sc.nextInt();
		balloons = new ArrayDeque<>();
		ansMaker = new StringBuilder();
		
		for(int balloonIdx = 0; balloonIdx < n; balloonIdx++) {
			int nowNumber = sc.nextInt();
			balloons.addLast(new Balloon(balloonIdx + 1, nowNumber));
		}
	}
	
	static void burstBalloons() {
		int numberInBalloon = 0;
		
		while(!balloons.isEmpty()) {
			while(numberInBalloon != 0) {
				if(numberInBalloon < 0) {
					balloons.addFirst(balloons.removeLast());
					numberInBalloon++;
				}
				else if(numberInBalloon > 0) {
					balloons.addLast(balloons.removeFirst());
					numberInBalloon--;
				}
			}
			
			Balloon now = balloons.removeFirst();
			ansMaker.append(now.index + " ");
			numberInBalloon = now.number > 0 ? now.number - 1 : now.number;
		}
		
	}
	
	static class Balloon {
		int index;
		int number;
		
		public Balloon(int index, int number) {
			this.index = index;
			this.number = number;
		}
		
	}
	
}