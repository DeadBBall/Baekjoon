import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static final int SINGLE = 1;
	static final int DOUBLE = 2;
	static final int TRIPLE = 3;
	static final int HOMERUN = 4;
	static int n, ans;
	static int[][] players;
	static boolean[] visit;
	static List<Integer> lineup;

	public static void main(String[] args) {
		input();
		setLineup();
		System.out.println(ans);
	}

	static void input() {
		n = SC.nextInt();
		players = new int[n][10];
		visit = new boolean[10];
		lineup = new ArrayList<>();

		for (int inning = 0; inning < n; inning++) {
			for (int playerIdx = 1; playerIdx <= 9; playerIdx++) {
				players[inning][playerIdx] = SC.nextInt();
			}
		}
	}

	static void setLineup() {
		if (lineup.size() == 8) {
			lineup.add(3, 1);
			int score = playBaseball();
			ans = Math.max(score, ans);
			lineup.remove(3);
			return;
		}

		for (int player = 2; player <= 9; player++) {
			if (visit[player]) continue;
			
			visit[player] = true;
			lineup.add(player);
			
			setLineup();
			
			visit[player] = false;
			lineup.remove(lineup.size() - 1);
		}
	}

	static int playBaseball() {
		int score = 0;
		boolean third = false;
		boolean second = false;
		boolean first = false;
		int outCount = 0;
		int playerIdx = 0;
		
		for (int inning = 0; inning < n; inning++) {

			while (outCount < 3) {
				int player = lineup.get(playerIdx);
				int record = players[inning][player];
				
				if (record == SINGLE) {
					if (third) {
						score++;
						third = false;
					}
					if (second) {
						second = false;
						third = true;
					}
					if (first) {
						second = true;
					}
					first = true;
				}
				
				else if (record == DOUBLE) {
					if (third) {
						score++;
						third = false;
					}
					if (second) {
						score++;
					}
					if (first) {
						third = true;
						first = false;
					}
					second = true;
				}
				
				else if (record == TRIPLE) {
					if (third) {
						score++;
					}
					if (second) {
						score++;
						second = false;
					}
					if (first) {
						score++;
						first = false;
					}
					third = true;
				}
				
				else if (record == HOMERUN) {
					if (third) {
						score++;
						third = false;
					}
					if (second) {
						score++;
						second = false;
					}
					if (first) {
						score++;
						first = false;
					}
					score++;
				}
				else outCount++;
				
				playerIdx = (playerIdx + 1) % 9;
			}
			
			third = false;
			second = false;
			first = false;
			outCount = 0;
		}
		
		return score;
	}

}