import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static final int[] DY = {1, -1, 0, 0};
	static final int[] DX = {0, 0, 1, -1};
	static final char DOYEON = 'I';
	static final char WALL = 'X';
	static final char PERSON = 'P';
	static int n, m, ans;
	static char[][] board;
	static boolean[][] visit;
	static Position start;
	
	public static void main(String[] args) {
		input();
		meetPeople();
		System.out.println(ans == 0 ? "TT" : ans);
	}	
	
	static void input() {
		n = sc.nextInt();
		m = sc.nextInt();
		board = new char[n][m];
		visit = new boolean[n][m];
		
		for(int y = 0; y < n; y++) {
			String inputBoard = sc.next();
			for(int x = 0; x < m; x++) {
				board[y][x] = inputBoard.charAt(x);
				
				if(board[y][x] == DOYEON) {
					start = new Position(y, x);
					visit[y][x] = true;
				}
			}
		}
	}
	
	static void meetPeople() {
		Queue<Position> positionQueue = new LinkedList<>();
		positionQueue.add(start);
		
		while(!positionQueue.isEmpty()) {
			Position now = positionQueue.remove();
			for(int drct = 0; drct < 4; drct++) {
				int ny = now.y + DY[drct];
				int nx = now.x + DX[drct];
				
				if(!canMove(ny, nx)) continue;				
				if(board[ny][nx] == WALL) continue;
				visit[ny][nx] = true;
				if(board[ny][nx] == PERSON) ans++;
				
				positionQueue.add(new Position(ny, nx));
			}
		}
	}
	
	static boolean canMove(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < m && !visit[y][x];
	}
	
	
	
	static class Position {
		int y;
		int x;
		
		Position(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}