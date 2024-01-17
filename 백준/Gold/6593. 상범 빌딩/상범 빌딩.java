import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static final int[] DF = {1, -1, 0, 0, 0, 0};
	static final int[] DY = {0, 0, 1, -1, 0, 0};
	static final int[] DX = {0, 0, 0, 0, 1, -1};
	static final char START = 'S';
	static final char EMPTY = '.';
	static final char END = 'E';
	static final char WALL = '#';
	static Position start;
	static int l, r, c;
	static char[][][] board;
	static StringBuilder ansMaker = new StringBuilder();
	
	public static void main(String[] args) {
		while(true) {
			input();
			if(l == 0) break;
			escapeSangBeomBuilding();
		}
		System.out.print(ansMaker);
	}

	static void input() {
		l = SC.nextInt();
		r = SC.nextInt();
		c = SC.nextInt();
		
		board = new char[l][r][c];
		
		for(int floor = 0; floor < l; floor++) {
			for(int y = 0; y < r; y++) {
				String inputY = SC.next();
				
				for(int x = 0; x < c; x++) {
					board[floor][y][x] = inputY.charAt(x);
					
					if(board[floor][y][x] == 'S')
						start = new Position(floor, y, x, 0);
					
				}
			}
		}
	}
	
	static void escapeSangBeomBuilding() {
		PriorityQueue<Position> positionQueue = new PriorityQueue<>(new Comparator<Position>() {
			@Override
			public int compare(Position a, Position b) {
				return a.minute - b.minute;
			}
		});
		
		positionQueue.add(start);
		
		while(!positionQueue.isEmpty()) {
			Position now = positionQueue.remove();
			
			for(int drct = 0; drct < 6; drct++) {
				Position next = new Position(now.floor + DF[drct],
						now.y + DY[drct], now.x + DX[drct], now.minute + 1);
				
				if(!canMove(next)) continue;
												
				if(next.checkBoard() == END) {
					ansMaker.append("Escaped in " + next.minute + " minute(s).\n");
					return;
				}
				
				board[next.floor][next.y][next.x] = WALL;
				
				positionQueue.add(next);
			}
			
		}

		ansMaker.append("Trapped!\n");
	}
	
	static boolean canMove(Position now) {
		return now.floor >= 0 && now.floor < l && now.y >= 0
				&& now.y < r && now.x >= 0 && now.x < c
				&& (now.checkBoard() == EMPTY || now.checkBoard() == END);
	}
	
	static class Position {
		int floor;
		int y;
		int x;
		int minute;
		
		public Position(int floor, int y, int x, int minute) {
			this.floor = floor;
			this.y = y;
			this.x = x;
			this.minute = minute;
		}
		
		char checkBoard() {
			return board[floor][y][x];
		}
		
	}
	
}