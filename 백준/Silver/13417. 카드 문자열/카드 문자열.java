import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static int n;
	static char[] cards;
	static StringBuilder ansMaker = new StringBuilder();
	
    public static void main(String[] args) {
    	int t = SC.nextInt();
    	
    	while(t-- > 0) {
    		input();
    		makeWord();
    	}
    	System.out.println(ansMaker);
    }

    static void input() {
    	n = SC.nextInt();
    	cards = new char[n];
    	
    	for(int cardIdx = 0; cardIdx < n; cardIdx++) {
    		cards[cardIdx] = SC.next().charAt(0);
    	}
    }
    
    static void makeWord() {
    	StringBuilder wordMaker = new StringBuilder();
    	
    	wordMaker.append(cards[0]);
    	
    	for(int cardIdx = 1; cardIdx < n; cardIdx++) {
    		
    		if(wordMaker.charAt(0) >= cards[cardIdx])
    			wordMaker.insert(0, cards[cardIdx]);
    		else
    			wordMaker.append(cards[cardIdx]);
    	}
    	ansMaker.append(wordMaker.toString()).append("\n");
    }

}