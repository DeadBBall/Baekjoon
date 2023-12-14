import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static final int ENEMY = 1;
	static final int EMPTY = 0;
	static int n, m, d, ans, totalEnemy, nowEnemy;
	static int[][] board;
	static int[][] newBoard;
	static List<Archer> archers;

	public static void main(String[] args) {
		input();
		deployArchers(0);
		System.out.println(ans);
	}

	static void input() {
		n = SC.nextInt();
		m = SC.nextInt();
		d = SC.nextInt();
		archers = new ArrayList<>();

		board = new int[n][m];
		newBoard = new int[n][m];
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				board[y][x] = SC.nextInt();
				if(board[y][x] == 1) totalEnemy++;
			}
		}

	}

	static void deployArchers(int nowArcher) {
		if (archers.size() == 3) {
			int enemyCount = playCastleDefense();
			ans = Math.max(enemyCount, ans);
			return;
		}

		for (int archerIdx = nowArcher; archerIdx < m; archerIdx++) {
			archers.add(new Archer(n, archerIdx));
			deployArchers(archerIdx + 1);
			archers.remove(archers.size() - 1);
		}
	}

	static int playCastleDefense() {
		nowEnemy = totalEnemy;
		int totalKillCount = 0;
		copyBoard();
		resetArchers();

		while (nowEnemy != 0) {
			totalKillCount += killEnemy();
			nowEnemy -= moveEnemy();
		}

		return totalKillCount;
	}
	
	static void copyBoard() {
		for(int y = 0; y < n; y++) {
			for(int x = 0; x < m; x++) {
				newBoard[y][x] = board[y][x];
			}
		}
	}
	
	static void resetArchers() {
		for(Archer archer : archers) {
			archer.y = n;
		}
	}

	static int killEnemy() {
		int killCount = 0;
		int archerY = archers.get(0).y;
		
		for (Archer archer : archers) {
			archer.targetX = -1;
			archer.targetY = -1;
			
			for(int y = archerY - 1; y >= 0; y--) {
				for(int x = 0; x < m; x++) {
					if(newBoard[y][x] == ENEMY) {
						int diff = archer.caluclateDistance(y, x);
						if(diff <= d) {
							int targetDiff = archer.caluclateDistance(archer.targetY, archer.targetX);
							if(archer.targetX == -1) {
								archer.targetX = x;
								archer.targetY = y;
							}
							else if(diff < targetDiff ||(diff == targetDiff && archer.targetX > x)) {
								archer.targetX = x;
								archer.targetY = y;
							}
						}
					}
				}
			}
			
		}

		for (Archer archer : archers) {
			if(archer.targetX == -1) continue;
			
			if(newBoard[archer.targetY][archer.targetX] == ENEMY) {
				killCount++;
				newBoard[archer.targetY][archer.targetX] = EMPTY;
			}
		}
		nowEnemy -= killCount;
		
		return killCount;
	}

	static int moveEnemy() {
		int movedEnemy = 0;
		for(Archer archer : archers) {
			archer.y--;
		}
		int archerY = archers.get(0).y;
		
		if(archerY != -1) {
			for(int x = 0; x < m; x++) {
				if(newBoard[archerY][x] == ENEMY) movedEnemy++;
			}
		}
		return movedEnemy;
	}

}

class Archer {
	int y;
	int x;
	int targetY;
	int targetX;
	
	public Archer(int y, int x) {
		this.y = y;
		this.x = x;
		this.targetY = -1;
		this.targetX = -1;
	}
	
	public int caluclateDistance(int y, int x) {
		return Math.abs(y - this.y) + Math.abs(x - this.x);
	}
}