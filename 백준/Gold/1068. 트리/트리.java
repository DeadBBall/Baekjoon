import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static int m;
	static List<Integer>[] line;
	static int root;
	static int ans;
	
	static void input() {
		n = sc.nextInt();
		line = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			line[i] = new ArrayList<>();			
		}
		for(int i = 0; i < n; i++) {
			int num = sc.nextInt();
			if(num == -1) {
				root = i;
				continue;
			}
			line[num].add(i);
		}
		m = sc.nextInt();
	}

	static void searchNode(int start) {
		if(line[start].size() == 0 || (line[start].size() == 1 && line[start].get(0) == m)) {
			ans++;
			return;
		}
		for(int i = 0; i < line[start].size(); i++) {
			int end = line[start].get(i);
			if(end != m)
			searchNode(end);
		}
	}
	
	public static void main(String[] args) {
		input();
		if(m != root) {
			searchNode(root);			
		}
		System.out.println(ans);
	}
}