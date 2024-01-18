import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static int n, ans;
	static Egg[] eggs;
	
	public static void main(String[] args) {
		input();
		solvePuzzle(0, 0);
		System.out.println(ans);
	}

	static void input() {
		n = SC.nextInt();
		eggs = new Egg[n];
		
		for(int eggIdx = 0; eggIdx < n; eggIdx++) {
			int durability = SC.nextInt();
			int weight = SC.nextInt();
			
			eggs[eggIdx] = new Egg(durability, weight);
		}
	}
	
	static void solvePuzzle(int nowEgg, int brokenEggs) {
		if(nowEgg == n) {
			ans = Math.max(ans, brokenEggs);
			return;
		}
		
		if(eggs[nowEgg].durability <= 0 || brokenEggs == n - 1) {
			solvePuzzle(nowEgg + 1, brokenEggs);
			return;
		}
		
		for(int targetEgg = 0; targetEgg < n; targetEgg++) {
			if(nowEgg == targetEgg) continue;
			
			if(eggs[targetEgg].durability <= 0) continue;
			
			int nowBrokenEggs = brokenEggs;
			
			hitEgg(nowEgg, targetEgg);		
			
			if(eggs[nowEgg].durability <= 0)
				nowBrokenEggs++;
			
			if(eggs[targetEgg].durability <= 0)
				nowBrokenEggs++;
			
			solvePuzzle(nowEgg + 1, nowBrokenEggs);
			
			restoreEgg(nowEgg, targetEgg);
		}
	}
	
	static void hitEgg(int nowEgg, int targetEgg) {
		eggs[nowEgg].durability -= eggs[targetEgg].weight;
		eggs[targetEgg].durability -= eggs[nowEgg].weight;
	}
	
	static void restoreEgg(int nowEgg, int targetEgg) {
		eggs[nowEgg].durability += eggs[targetEgg].weight;
		eggs[targetEgg].durability += eggs[nowEgg].weight;
	}
	
}

class Egg {
	int durability;
	int weight;
	
	public Egg(int durability, int weight) {
		this.durability = durability;
		this.weight = weight;
	}
	
}