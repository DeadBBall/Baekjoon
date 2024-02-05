import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static final int[] DY = { -1, 1, -2, -2, -1, 1, 2, 2 };
	static final int[] DX = { -2, -2, -1, 1, 2, 2, -1, 1 };
	
	public static void main(String[] args) {		
		System.out.println(knightTravel() ? "Valid" : "Invalid");
	}

	static boolean knightTravel() {
		boolean[][] visit = new boolean[6][6];
		
		int startX = 0;
		int startY = 0;
				
		int beforeX = 0;
		int beforeY = 0;
		
		for(int posIdx = 0; posIdx < 36; posIdx++) {
			
			String now = SC.next();
			int nowX = now.charAt(0) - 'A';
			int nowY = now.charAt(1) - '1';
			
			if(visit[nowY][nowX]) return false;
			
			visit[nowY][nowX] = true;
			boolean canMove = false;
			
			if(posIdx == 0) {
				startX = beforeX = nowX;
				startY = beforeY = nowY;
				canMove = true;
			}
			
			else {
				for(int drct = 0; drct < 8; drct++) {
					int ny = beforeY + DY[drct];
					int nx = beforeX + DX[drct];
					
					if(ny == nowY && nx == nowX) {
						canMove = true;
						beforeY = nowY;
						beforeX = nowX;
						break;
					}
				}
			}
			
			if(!canMove) return false;
		}
		
		for(int drct = 0; drct < 8; drct++) {
			int ny = beforeY + DY[drct];
			int nx = beforeX + DX[drct];
			
			if(ny == startY && nx == startX) {
				return true;
			}
		}
		
		return false;
	}
}