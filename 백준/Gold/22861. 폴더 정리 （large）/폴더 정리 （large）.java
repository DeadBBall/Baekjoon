import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder ansMaker = new StringBuilder();
	static int n, m, k;
	static Map<String, Folder> folders;
	static Set<String> files;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		folders = new HashMap<>();
		for (int i = 0; i < n + m; i++) {
			st = new StringTokenizer(br.readLine());
			String p = st.nextToken();
			String f = st.nextToken();
			int c = Integer.parseInt(st.nextToken());
			if (!folders.containsKey(p)) {
				folders.put(p, new Folder());
			}
			if (!folders.containsKey(f)) {
				folders.put(f, new Folder());
			}
			if (c == 1) {
				folders.get(p).addFolder(folders.get(f));
			} else {
				folders.get(p).addFile(f);
			}
		}
		k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			String[] tmp = st.nextToken().split("/");
			String a = tmp[tmp.length - 1];
			tmp = st.nextToken().split("/");
			String b = tmp[tmp.length - 1];
			Folder tmpF = folders.get(a);
			Folder tmpF2 = folders.get(b);
			tmpF2.getFiles().addAll(tmpF.getFiles());
			tmpF2.getFolders().addAll(tmpF.getFolders());
			tmpF.delete();
		}
		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			checkFolder();
		}
	}

	static void checkFolder() throws IOException {
		st = new StringTokenizer(br.readLine());
		String[] inputStr = st.nextToken().split("/");
		String target = inputStr[inputStr.length - 1];
		int sum = 0;
		files = new HashSet<>();
		Queue<Folder> q = new LinkedList<>();
		q.add(folders.get(target));
		while(!q.isEmpty()) {
			Folder tmp = q.remove();
			files.addAll(tmp.getFiles());
			sum += tmp.getFiles().size();
			q.addAll(tmp.getFolders());
		}
		ansMaker.append(files.size()).append(" ").append(sum).append("\n");
	}

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(ansMaker);
	}
	
	static class Folder {
		Set<Folder> folders = new HashSet<>();
		Set<String> files = new HashSet<>();
		
		public Folder() {
		}
		
		public Set<Folder> getFolders() {
			return folders;
		}

		public Set<String> getFiles() {
			return files;
		}

		public void setFolders(Set<Folder> folders) {
			this.folders = folders;
		}

		public void setFiles(Set<String> files) {
			this.files = files;
		}
		
		public void addFile(String file) {
			files.add(file);
		}
		
		public void addFolder(Folder folder) {
			folders.add(folder);
		}
		
		public void delete() {
			folders = new HashSet<>();
			files = new HashSet<>();
		}
	}
}