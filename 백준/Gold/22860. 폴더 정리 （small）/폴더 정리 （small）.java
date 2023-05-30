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
	static Map<String, Integer> nameToNum;
	static Map<Integer, String> numToName;
	static List<Integer>[] children;
	static Set<String> files;
	
	static void input() {
		n = sc.nextInt();
		m = sc.nextInt();
		children = new ArrayList[n + 1];
		nameToNum = new HashMap<>();
		folders = new HashMap<>();
		numToName = new HashMap<>();
		int folderIdx = 0;
		for (int i = 0; i < n + m; i++) {
			String p = sc.next();
			String f = sc.next();
			int c = sc.nextInt();
			if(!nameToNum.containsKey(p)) {
				nameToNum.put(p, folderIdx);
				numToName.put(folderIdx, p);
				children[folderIdx++] = new ArrayList<>();
				folders.put(p, new ArrayList<>());
			}
			if (c == 1) {
				int idx = nameToNum.get(p);
				if(!nameToNum.containsKey(f)) {
					nameToNum.put(f, folderIdx);
					numToName.put(folderIdx, f);
					children[folderIdx] = new ArrayList<>();
					folders.put(f, new ArrayList<>());					
					children[idx].add(folderIdx++);
				}
				else {
					children[idx].add(nameToNum.get(f));
				}
			} else {
				List<String> tmpList = folders.get(p);
				tmpList.add(f);
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
			Queue<Integer> q = new LinkedList<>();
			List<String> tmpList = folders.get(target);
			for (int j = 0; j < tmpList.size(); j++) {
				files.add(tmpList.get(j));
				sum++;
			}
			for(int j = 0; j < children[nameToNum.get(target)].size(); j++) {
				q.add(children[nameToNum.get(target)].get(j));
			}
			while (!q.isEmpty()) {
				int num = q.remove();
				String folder = numToName.get(num);
				tmpList = folders.get(folder);
				for(int j = 0; j < tmpList.size(); j++) {
					files.add(tmpList.get(j));
					sum++;
				}
				for(int j = 0; j < children[nameToNum.get(folder)].size(); j++) {
					q.add(children[nameToNum.get(folder)].get(j));
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