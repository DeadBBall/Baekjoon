import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static final int[] DY = { 1, -1, 0, 0 };
	static final int[] DX = { 0, 0, 1, -1 };
	static final char SOM = 'S';
	static final char YEON = 'Y';
	static char[][] board;
	static int ans;
	static Set<Integer> princesses;

	public static void main(String[] args) {
		input();
		organizeSevenPrincess(0, 0, 0);
		System.out.println(ans);
	}

	static void input() {
		board = new char[5][5];

		for (int y = 0; y < 5; y++) {
			String inputBoard = SC.next();
			for (int x = 0; x < 5; x++) {
				board[y][x] = inputBoard.charAt(x);
			}
		}

		princesses = new HashSet<>();
	}

	static void organizeSevenPrincess(int start, int somCount, int totalCount) {
		if(7 - totalCount + somCount < 4) return;
		
		if (totalCount == 7) {
			
			if (checkSevenPrincess())
				ans++;
			return;
		}

		for (int now = start; now < 25; now++) {
			princesses.add(now);
			organizeSevenPrincess(now + 1, board[now / 5][now % 5] == SOM ? somCount + 1 : somCount, totalCount + 1);
			princesses.remove(now);
		}
	}

	static boolean checkSevenPrincess() {
		boolean[] visit = new boolean[25];
		
		int bfsCount = 1;
		int now = princesses.iterator().next();
		visit[now] = true;
		
		Queue<Integer> princessQueue = new LinkedList<>();
		princessQueue.add(now);
		
		while(!princessQueue.isEmpty()) {
			now = princessQueue.remove();
			
			int y = now / 5;
			int x = now % 5;
			
			for(int drct = 0; drct < 4; drct++) {
				int ny = y + DY[drct];
				int nx = x + DX[drct];
				
				if(!canMove(ny, nx)) continue;
				
				int next = ny * 5 + nx;
				
				if(visit[next] || !princesses.contains(next)) continue;
				
				visit[next] = true;
				
				princessQueue.add(next);
				
				bfsCount++;
			}
			
		}
		
		return bfsCount == 7;
	}
	
	static boolean canMove(int y, int x) {
		return y >= 0 && y < 5 && x >= 0 && x < 5;
	}

}