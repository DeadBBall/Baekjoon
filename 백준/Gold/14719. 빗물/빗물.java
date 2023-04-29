import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int h, w;
	static boolean[][] board;
	static int ans;
	
	static void input() {
		h = sc.nextInt();
		w = sc.nextInt();
		board = new boolean[h][w];
		for(int x = 0; x < w; x++) {
			int now = sc.nextInt();
			for(int y = 0; y < now; y++) {
				board[y][x] = true;
			}
		}
	}

	static void checkRain() {
		for(int y = 0; y < h; y++) {
			boolean isWall = false;
			int sum = 0;
			for(int x = 0; x < w; x++) {
				if(board[y][x] && !isWall) {
					isWall = true;
				}
				else if(board[y][x] && isWall) {
					ans += sum;
					sum = 0;
				}
				else if(!board[y][x] && isWall) {
					sum++;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		input();
		checkRain();
		System.out.println(ans);
	}
}