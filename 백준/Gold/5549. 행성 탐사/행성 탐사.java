import java.util.Scanner;

public class Main {
   
   static Scanner sc = new Scanner(System.in);
   static final char JUNGLE = 'J';
   static final char ICE = 'I';
   static final char OCEAN = 'O';
   static int m, n, t;
   static String[] board;
   static int[][] jungleSum;
   static int[][] iceSum;
   static int[][] oceanSum;
   static StringBuilder ansMaker;
   
   public static void main(String[] args) {
	   input();
	   calculateInfoSum();
	   while(t-- > 0) {
		   searchBoard();
	   }
	   System.out.print(ansMaker);
   }
   
   static void input() {
	   m = sc.nextInt();
	   n = sc.nextInt();
	   t = sc.nextInt();
	   
	   board = new String[m];
	   
	   for(int y = 0; y < m; y++) {
		   board[y] = sc.next();
	   }
	   jungleSum = new int[m + 1][n + 1];
	   iceSum = new int[m + 1][n + 1];
	   oceanSum = new int[m + 1][n + 1];
	   
	   ansMaker = new StringBuilder();
   }
   
   static void calculateInfoSum() {
	   for(int y = 1; y <= m; y++) {
		   for(int x = 1; x <= n; x++) {
			   jungleSum[y][x] = jungleSum[y - 1][x] + jungleSum[y][x - 1] - jungleSum[y - 1][x - 1];
			   iceSum[y][x] = iceSum[y - 1][x] + iceSum[y][x - 1] - iceSum[y - 1][x - 1];
			   oceanSum[y][x] = oceanSum[y - 1][x] + oceanSum[y][x - 1] - oceanSum[y - 1][x - 1];
			   
			   if(board[y - 1].charAt(x - 1) == JUNGLE)
				   jungleSum[y][x]++;
			   else if(board[y - 1].charAt(x - 1) == OCEAN)
				   oceanSum[y][x]++;
			   else
				   iceSum[y][x]++;
		   }
	   }
   }
   
   static void searchBoard() {
	   int a = sc.nextInt();
	   int b = sc.nextInt();
	   int c = sc.nextInt();
	   int d = sc.nextInt();
	   
	   int jungle = jungleSum[c][d] - jungleSum[a - 1][d] - jungleSum[c][b - 1] + jungleSum[a - 1][b - 1];
	   int ice = iceSum[c][d] - iceSum[a - 1][d] - iceSum[c][b - 1] + iceSum[a - 1][b - 1];
	   int ocean = oceanSum[c][d] - oceanSum[a - 1][d] - oceanSum[c][b - 1] + oceanSum[a - 1][b - 1];
	   
	   ansMaker.append(jungle + " " + ocean + " " + ice + " \n");
   }
}