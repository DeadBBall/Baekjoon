import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n, k;
	static int ans;
	static int[] board;
	static int[] robot;
	
	static void input() {
		n = sc.nextInt();
		k = sc.nextInt();
		board = new int[n * 2];
		robot = new int[n * 2];
		for(int i = 0; i < 2 * n; i++) {
			board[i] = sc.nextInt();
		}
	}
	
	static void rotateAll() {
		int tmpBoard = board[n * 2 - 1];
		robot[n - 1] = 0;
		for(int i = 2 * n - 1; i > 0; i--) {
			board[i] = board[i - 1];
			robot[i] = robot[i - 1];
		}
		board[0] = tmpBoard;
		robot[0] = 0;
		robot[n - 1] = 0;
	}
	
	static void moveRobot() {
		for(int i = n - 2; i >= 0; i--) {
			if(board[i + 1] >= 1 && robot[i] != 0 && robot[i + 1] == 0) {
				robot[i + 1] = robot[i];
				robot[i] = 0;
				board[i + 1]--;
			}
		}
	}
	
	static void makeRobot() {
		if(board[0] != 0 && robot[0] == 0) {
			robot[0] = 1;
			board[0]--;
		}
	}
	static boolean checkZero() {
		int sum = 0;
		for(int i = 0; i < n * 2; i++) {
			if(board[i] == 0) {
				sum++;
			}
		}
		if(sum >= k) {
			return true;
		}
		return false;
	}
	
	static void operateBelt() {
		while(true) {
			ans++;
			rotateAll();
			moveRobot();
			makeRobot();
			if(checkZero()) {
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		input();
		operateBelt();
		System.out.println(ans);
	}
}