import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n, m;
	static Map<String, List<String>> folders;
	static Map<String, List<String>> children;
	static Set<String> files;
	
	static void input() {
		n = sc.nextInt();
		m = sc.nextInt();
		children = new HashMap<>();
		folders = new HashMap<>();
		for (int i = 0; i < n + m; i++) {
			String p = sc.next();
			String f = sc.next();
			int c = sc.nextInt();
			if(!folders.containsKey(p)) {
				folders.put(p, new ArrayList<>());
				children.put(p, new ArrayList<>());
			}
			if(!folders.containsKey(f)) {
				folders.put(f, new ArrayList<>());
				children.put(f, new ArrayList<>());
			}
			if(c == 1) {
				children.get(p).add(f);
			}
			else {
				folders.get(p).add(f);
			}
		}
	}
	
	static void checkFolder() {
		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			String[] inputStr = sc.next().split("/");
			String target = inputStr[inputStr.length - 1];
			int sum = 0;
			files = new HashSet<>();
			Queue<String> q = new LinkedList<>();
			q.add(target);
			while(!q.isEmpty()) {
				target = q.remove();
				List<String> tmpList = folders.get(target);
				for(int i = 0; i < tmpList.size(); i++) {
					files.add(tmpList.get(i));
					sum++;
				}
				tmpList = children.get(target);
				for(int i = 0; i < tmpList.size(); i++) {
					q.add(tmpList.get(i));
				}
			}
			System.out.println(files.size() + " " + sum);
		}
	}

	public static void main(String[] args) {
		input();
		checkFolder();
	}
}