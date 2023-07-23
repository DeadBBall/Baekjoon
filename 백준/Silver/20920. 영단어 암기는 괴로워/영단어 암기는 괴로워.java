import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
//	static Scanner sc = new Scanner(System.in);
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int m;
	static int ans;
	static Map<String, Integer> map;	
	
	static void input() throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new HashMap<>();
		for(int i = 0; i < n; i++) {
			String now = br.readLine();
			if(now.length() >= m) {
				if(map.containsKey(now)) {
					map.put(now, map.get(now) + 1);
				}
				else {
					map.put(now, 1);
				}
			}
		}
	}
	
	static void makeVocabulary() throws IOException {
		List<String> wordList = new ArrayList<>(map.keySet());
		Collections.sort(wordList, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				int aCnt = map.get(a);
				int bCnt = map.get(b);
				int aLen = a.length();
				int bLen = b.length();
				if(aCnt == bCnt) {
					if(aLen == bLen) {
						return a.compareTo(b);
					}
					return bLen - aLen;
				}
				return bCnt - aCnt;
			}
		});
		for(String word : wordList) {
			bw.write(word + "\n");
		}
		bw.close();
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		makeVocabulary();
	}	
}