import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static final int EMPTY = 0;
    static final int WALL = 1;
    static final int VIRUS = 2;
    static final int ACTIVATEDVIRUS = -1;
    static final int[] DY = {1, -1, 0, 0};
    static final int[] DX = {0, 0, 1, -1};
    static int n, m, ans;
    static int[][] board;
    static int[][] copiedBoard;
    static List<Virus> virusList;
    
    public static void main(String[] args) {
        input();
        choiceVirus(0, new ArrayList<Integer>());
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static void input() {
    	n = sc.nextInt();
    	m = sc.nextInt();
    	board = new int[n][n];
    	virusList = new ArrayList<>();
    	ans = Integer.MAX_VALUE;
    	
    	for(int y = 0; y < n; y++) {
    		for(int x = 0; x < n; x++) {
    			board[y][x] = sc.nextInt();
    			if(board[y][x] == VIRUS)
    				virusList.add(new Virus(y, x, 0));
    		}
    	}
    	
    	
    }
    
    static void choiceVirus(int now, List<Integer> idxList) {
    	if(idxList.size() == m) {
    		ans = Math.min(checkVirus(idxList), ans);
    		return;
    	}
    	
    	if(now == virusList.size()) return;
    	
    	for(int idx = now; idx < virusList.size(); idx++) {
    		idxList.add(idx);
    		choiceVirus(idx + 1, idxList);
    		idxList.remove(idxList.size() - 1);
    	}
    	
    }
    
    static int checkVirus(List<Integer> idxList) {
    	copiedBoard = new int[n][n];
    	copyBoard();
    	
    	PriorityQueue<Virus> virusQueue = new PriorityQueue<>(new Comparator<Virus>() {
    		@Override
    		public int compare(Virus a, Virus b) {
    			return a.time - b.time;
    		}
		});
    	for(int num : idxList) {
    		Virus nowVirus = virusList.get(num); 
    		virusQueue.add(nowVirus);
    		copiedBoard[nowVirus.y][nowVirus.x] = ACTIVATEDVIRUS;
    	}
    	
    	int time = 0;
		if(checkBoard()) return time;
    	
    	while(!virusQueue.isEmpty()) {
    		Virus now = virusQueue.remove();
//    		System.out.println(now.y + " " + now.x + " " + now.time);
    		if(now.time != time) {
    			time++;
    			if(checkBoard()) return time;
    		}
    		
    		for(int dir = 0; dir < 4; dir++) {
    			int ny = now.y + DY[dir];
    			int nx = now.x + DX[dir];
    			
    			if(!canMove(ny, nx)) continue;
    			
    			if(copiedBoard[ny][nx] != ACTIVATEDVIRUS) {
    				copiedBoard[ny][nx] = ACTIVATEDVIRUS;
    				virusQueue.add(new Virus(ny, nx, now.time + 1));
    			}
    		}
    		time = now.time;
    	}
    	
    	if(checkBoard())
    		return time;
    	return Integer.MAX_VALUE;
    }
    
    static void copyBoard() {
    	for(int y = 0; y < n; y++) {
    		for(int x = 0; x < n; x++) {
    			copiedBoard[y][x] = board[y][x];
    		}
    	}
    }
    
    static boolean canMove(int y, int x) {
    	return !(y < 0 || x < 0 || y >= n || x >= n || copiedBoard[y][x] == WALL || copiedBoard[y][x] == ACTIVATEDVIRUS);
    }
    
    static boolean checkBoard() {
    	for(int y = 0; y < n; y++) {
    		for(int x = 0; x < n; x++) {
    			if(copiedBoard[y][x] == EMPTY) return false;
    		}
    	}
    	return true;
    }
    
    static class Virus {
    	int y;
    	int x;
    	int time;
    	
    	public Virus(int y, int x, int time) {
    		this.y = y;
    		this.x = x;
    		this.time = time;
    	}
    }
    
}