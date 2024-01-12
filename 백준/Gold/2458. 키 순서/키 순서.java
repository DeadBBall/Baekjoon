import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static final int INF = 123456789; 
	static int n, m, ans;
	static boolean[][] diffs;

    public static void main(String[] args) {
    	input();
    	compareHeight();
    	System.out.println(ans);
    }

    static void input() {
    	n = SC.nextInt();
    	m = SC.nextInt();
    	
    	diffs = new boolean[n + 1][n + 1];

    	while(m-- > 0) {
    		int small = SC.nextInt();
    		int big = SC.nextInt();
    		
    		diffs[small][big] = true;
    	}
    	
    }
    
    static void compareHeight() {
    	for(int mid = 1; mid <= n; mid++) {
    		for(int start = 1; start <= n; start++) {
    			if(mid == start) continue;
    			
    			for(int end = 1; end <= n; end++) {
    				if(start == end) continue;
    				
    				if(diffs[start][mid] && diffs[mid][end])
    					diffs[start][end] = true;
    				
    			}
    		}
    	}
    	
    	int count = 0;
    	
    	for(int start = 1; start <= n; start++) {
    		
    		for(int end = 1; end <= n; end++) {
    			if(start == end) continue;
    			
    			if(!diffs[start][end] && !diffs[end][start]) {
    				count++;
    				break;
    			}
    		}
    		
    	}
    	
    	ans = n - count;
    	
    }

}