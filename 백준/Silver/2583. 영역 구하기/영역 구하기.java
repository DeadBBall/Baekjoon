import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int m;
	static int n;
	static int k;
	static boolean[][] map = new boolean[100][100]; 
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static int[] answer = new int[5000];
	static int answerIdx = 0;
	
	static void inputProblem() {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		k = sc.nextInt();
		for(int i = 0; i < k; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			for(int y = y1; y < y2; y++) {
				for(int x = x1; x < x2; x++) {
					map[y][x] = true;
				}
			}
		}
		sc.close();
	}
	
	static void bfs(int y, int x) {
		Queue<Pair> queue = new LinkedList<>();
		int tmpSize = 1;
		queue.add(new Pair(y, x));
		while(!queue.isEmpty()) {
			Pair now = queue.peek();
			queue.poll();
			map[now.y][now.x] = true;
			for(int i = 0; i < 4; i++) {
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];
				if(ny < 0 || nx < 0 || ny >= m || nx >= n || map[ny][nx]) {
					continue;
				}
				map[ny][nx] = true;
				queue.add(new Pair(ny, nx));
				tmpSize++;
			}
		}
		answer[answerIdx] = tmpSize;
	}
	
	static void searchPaper() {
		for(int y = 0; y < m; y++) {
			for(int x = 0; x < n; x++) {
				if(!map[y][x]) {
					bfs(y, x);
					answerIdx++;
				}
			}
		}
	}
	
	static void solve() {
		inputProblem();
		searchPaper();
		Arrays.sort(answer, 0, answerIdx);
		System.out.println(answerIdx);
		for(int i = 0; i < answerIdx; i++) {
			System.out.print(answer[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		solve();
	}
}

class Pair {
	int x;
	int y;
	
	Pair(int y, int x) {
		this.y = y;
		this.x = x;
	}
}