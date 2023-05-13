import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static boolean[][] board;
    static int xMin = 101, xMax = 0, yMin = 101, yMax = 0;
    static int ans;
    
    static void input() {
    	board = new boolean[101][101];
    	int x1, y1, x2, y2;
    	for(int i = 0; i < 4; i++) {
    		x1 = sc.nextInt();
    		y1 = sc.nextInt();
    		x2 = sc.nextInt();
    		y2 = sc.nextInt();
    		xMin = Math.min(xMin, x1);
    		yMin = Math.min(yMin, y1);
    		xMax = Math.max(xMax, x2);
    		yMax = Math.max(yMax, y2);
    		for(int y = y1 + 1; y <= y2; y++) {
    			for(int x = x1 + 1; x <= x2; x++) {
    				board[y][x] = true;
    			}
    		}
    	}
    }
    
    static void calcArea() {
    	for(int y = yMin; y <= yMax; y++) {
    		for(int x = xMin; x <= xMax; x++) {
    			if(board[y][x]) {
    				ans++;
    			}
    		}
    	}
    }
    
    public static void main(String[] args) {
        input();
        calcArea();
        System.out.println(ans);
    }
}