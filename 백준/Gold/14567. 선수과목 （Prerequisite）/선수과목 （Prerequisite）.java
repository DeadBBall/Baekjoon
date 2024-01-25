import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static int n, m;
	static int[] in;
	static int[] semesters;
	static Queue<Integer> subjectQueue;
	static List<Integer>[] edges;
	
	public static void main(String[] args) {
		input();
		completeCourse();
	}
	
	static void input() {
		subjectQueue = new LinkedList<>();
		n = SC.nextInt();
		m = SC.nextInt();
		
		in = new int[n + 1];
		edges = new ArrayList[n + 1];
		semesters = new int[n + 1];
		
		for(int subjectIdx = 1; subjectIdx <= n; subjectIdx++) {
			edges[subjectIdx] = new ArrayList<>();
		}
		
		for(int edgeIdx = 0; edgeIdx < m; edgeIdx++) {
			int start = SC.nextInt();
			int end = SC.nextInt();
			
			in[end]++;
			edges[start].add(end);
		}
		
		for(int subjectIdx = 1; subjectIdx <= n; subjectIdx++) {
			if(in[subjectIdx] == 0) {
				subjectQueue.add(subjectIdx);
				semesters[subjectIdx] = 1;
			}
		}
		
	}
	
	static void completeCourse() {
		while(!subjectQueue.isEmpty()) {
			int start = subjectQueue.remove();
			
			for(int end : edges[start]) {
				in[end]--;
				
				if(in[end] == 0) {
					semesters[end] = semesters[start] + 1;
					subjectQueue.add(end);
				}
			}
		}
		
		for(int subjectIdx = 1; subjectIdx <= n; subjectIdx++) {
			System.out.print(semesters[subjectIdx] + " ");
		}
	}
	
}