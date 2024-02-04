import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static int n, h;
	static int[] stalactites;
	static int[] stalagmites;

	public static void main(String[] args) {
		input();
		destroyObstacle();
	}

	static void input() {
		n = SC.nextInt();
		h = SC.nextInt();
		stalagmites = new int[h + 1];
		stalactites = new int[h + 1];
		
		for(int obstacleIdx = 0; obstacleIdx < n; obstacleIdx++) {
			int obstacle = SC.nextInt();
			
			if(obstacleIdx % 2 == 0) {
				stalagmites[obstacle]++;
			}
			else {
				stalactites[obstacle]++;
			}
		}
	}
	
	static void destroyObstacle() {
		for(int height = h; height > 1; height--) {
			stalactites[height - 1] += stalactites[height];
			stalagmites[height - 1] += stalagmites[height];
		}
		
		List<Integer> obstacles = new ArrayList<>();
		
		
		for(int height = 1; height <= h; height++) {
			obstacles.add(stalactites[height] + stalagmites[h - height + 1]);
		}
		
		Collections.sort(obstacles);
		
		int obtacleCount = obstacles.get(0);
		int sectionCount = 1;
		
		for(int height = 1; height <= h; height++) {
			int nowObtacleCount = obstacles.get(height);
			
			if(nowObtacleCount == obtacleCount) {
				sectionCount++;
			}
			else break;
		}
		
		System.out.println(obtacleCount + " " + sectionCount);
	}
}