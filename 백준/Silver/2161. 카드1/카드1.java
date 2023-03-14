import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int n;
	static Queue<Integer> q = new LinkedList<Integer>();
	static StringBuilder ansMaker = new StringBuilder();
    
	public static void main(String[] args) {
		n = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			q.add(i);
		}
		while(!q.isEmpty()) {
			ansMaker.append(q.poll()).append(" ");
			if(!q.isEmpty()) {
				q.add(q.poll());				
			}
		}
        System.out.println(ansMaker);
	}
}