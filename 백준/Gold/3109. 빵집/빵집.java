import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static final char BUILDING = 'X';
	static final char EMPTY = '.';
	static final int[] DY = {-1, 0, 1};
	static int r, c, ans;
	static char[][] board;

	public static void main(String[] args) throws IOException {
		input();
		checkAll();
		System.out.println(ans);
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		board = new char[r][c];

		for(int y = 0; y < r; y++) {
			String inputBoard = br.readLine();
			for(int x = 0; x < c; x++) {
				board[y][x] = inputBoard.charAt(x);
			}
		}
	}
	
	static void checkAll() {
		for(int y = 0; y < r; y++) {
			board[y][0] = BUILDING;
			connectPipe(y, 0);
		}
	}
	
	static boolean connectPipe(int nowY, int nowX) {		
		if(nowX == c - 1) {
			ans++;
			return true;
		}
		
		for(int drct = 0; drct < 3; drct++) {
			int ny = nowY + DY[drct];
			int nx = nowX + 1;
			
			if(!canMove(ny, nx)) continue;
			
			board[ny][nx] = BUILDING;
			
			if(connectPipe(ny, nx)) return true;
		}
		
		return false;
	}
	
	static boolean canMove(int y, int x) {
		return y >= 0 && y < r && board[y][x] == EMPTY;
	}
}

class Pipe {
	int y;
	int x;
	
	public Pipe(int y, int x) {
		this.y = y;
		this.x = x;
	}
	
}