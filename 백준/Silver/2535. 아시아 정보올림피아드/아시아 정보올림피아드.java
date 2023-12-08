import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static Score[] scores;
	static int[] countryOfWinners;
	static StringBuilder ansMaker;
	
	public static void main(String[] args) {
		input();
		announceRanking();
		System.out.print(ansMaker);
	}	
	
	static void input() {
		n = sc.nextInt();
		scores = new Score[n];
		int maxCountry = 0;
		
		for(int studentIdx = 0; studentIdx < n; studentIdx++) {
			int country = sc.nextInt();
			int index = sc.nextInt();
			int score = sc.nextInt();
			scores[studentIdx] = new Score(country, index, score);
			maxCountry = Math.max(maxCountry, country);
		}
		
		countryOfWinners = new int[maxCountry + 1];
		ansMaker = new StringBuilder();
	}
	
	static void announceRanking() {
		Arrays.sort(scores, new Comparator<Score>() {
			@Override
			public int compare(Score o1, Score o2) {
				return o2.score - o1.score;
			}
		});
		
		int winnerCount = 0;
		int studentIdx = 0;
		while(winnerCount < 3) {
			Score now = scores[studentIdx];
			
			if(countryOfWinners[now.country] < 2) {
				countryOfWinners[now.country]++;
				ansMaker.append(now.country + " " + now.index + "\n");
				winnerCount++;
			}
			studentIdx++;
		}
	}
	
}

class Score {
	int country;
	int index;
	int score;
	
	public Score(int country, int index, int score) {
		this.country = country;
		this.index = index;
		this.score = score;
	}
	
}