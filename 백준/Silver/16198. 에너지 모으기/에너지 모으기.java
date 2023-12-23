import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static int n, ans;
	static List<Integer> energy;
	
	
	public static void main(String[] args) {
		input();
		findMaxEnergy(0);
		System.out.println(ans);
	}

	static void input() {
		n = SC.nextInt();
		energy = new ArrayList<>();
		
		for(int energyIdx = 0; energyIdx < n; energyIdx++) {
			int nowEnergy = SC.nextInt();
			energy.add(nowEnergy);
		}
		
	}

	static void findMaxEnergy(int sum) {
		if(energy.size() == 2) {
			ans = Math.max(ans, sum);
			return;
		}
		
		for(int energyIdx = 1; energyIdx < energy.size() - 1; energyIdx++) {
			int nowEnergy = energy.get(energyIdx - 1) * energy.get(energyIdx + 1);
			int removedEnergy = energy.remove(energyIdx);
			
			findMaxEnergy(sum + nowEnergy);
			energy.add(energyIdx, removedEnergy);
		}
	}
	
}