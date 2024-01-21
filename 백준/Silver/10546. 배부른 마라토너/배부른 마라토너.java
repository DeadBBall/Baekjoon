import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static int n;
	static Map<String, Integer> players;

	public static void main(String[] args) {
		input();
		checkFinisher();
		for(String player : players.keySet()) {
			System.out.println(player);
		}
	}

	static void input() {
		players = new HashMap<>();
		n = SC.nextInt();
		
		for(int playerIdx = 0; playerIdx < n; playerIdx++) {
			String player = SC.next();
			
			if(players.containsKey(player))
				players.put(player, players.get(player) + 1);
			else
				players.put(player, 1);
		}
		
	}
	
	static void checkFinisher() {
		for(int playerIdx = 0; playerIdx < n - 1; playerIdx++) {
			String player = SC.next();
			
			if(players.get(player) == 1)
				players.remove(player);
			else
				players.put(player, players.get(player) - 1);
		}
	}

}