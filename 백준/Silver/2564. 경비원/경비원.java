import java.util.Scanner;

public class Main {
	static final int NORTH = 1;
	static final int SOUTH = 2;
	static final int WEST = 3;
	static final int EAST = 4;
	static Scanner sc = new Scanner(System.in);
	static int ySize, xSize, storeCount, ans;
	static Position[] stores;
	static Position donggeun;
	
	public static void main(String[] args) {
		input();
		calculateMinDiff();
		System.out.println(ans);
	}
	
	static void input() {
		xSize = sc.nextInt();
		ySize = sc.nextInt();
		storeCount = sc.nextInt();
		stores = new Position[storeCount];
		int dir;
		int pos;
		
		for(int storeIdx = 0; storeIdx < storeCount; storeIdx++) {
			dir = sc.nextInt();
			pos = sc.nextInt();
			stores[storeIdx] = new Position(dir, pos);
		}
	
		dir = sc.nextInt();
		pos = sc.nextInt();
		donggeun = new Position(dir, pos);
		
	}

	static void calculateMinDiff() {
		for(int storeIdx = 0; storeIdx < storeCount; storeIdx++) {
			ans += donggeun.calculateDiff(stores[storeIdx]);
		}
	}
	
	static class Position {
		int y;
		int x;
		
		public Position(int dir, int pos) {
			switch (dir) {
			case NORTH:
				this.y = 0;
				this.x = pos;
				break;
			case SOUTH:
				this.y = ySize;
				this.x = pos;
				break;
			case WEST:
				this.y = pos;
				this.x = 0;
				break;
			default:
				this.y = pos;
				this.x = xSize;
				break;
			}
		}
		
		public int calculateDiff(Position other) {
			int diffY = Math.abs(other.y - y);
			int diffX = Math.abs(other.x - x); 
			int sumY = other.y + y;
			int sumX = other.x + x;
			
			if(sumY == 0 || sumY == ySize * 2) return diffX; 
			else if(sumX == 0 || sumX == xSize * 2) return diffY;
			else if(diffY == ySize) {
				int sum2 = 2 * xSize - sumX;
				return (sumX > sum2 ? sum2 : sumX) + ySize;
			}
			else if(diffX == xSize){
				int sum2 = 2 * ySize - sumY;
				return (sumY > sum2 ? sum2 : sumY) + xSize;
			}
			return diffY + diffX;
		}
	}
}