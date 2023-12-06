import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static Map<String, Integer> extensionMap = new HashMap<>();
	static String file;
	
	public static void main(String[] args) {
		int n = sc.nextInt();
		while(n-- > 0) {
			input();
			sortOutFile();
		}
		printExtensions();
	}	
	
	static void input() {
		file = sc.next();
	}
	
	static void sortOutFile() {
		String extension = file.split("\\.")[1];
		extensionMap.compute(extension, (k, v) -> (v == null) ? 1 : v + 1);
	}
	
	static void printExtensions() {
		String[] extensions = extensionMap.keySet().toArray(new String[0]);
		Arrays.sort(extensions);
		
		StringBuilder ansMaker = new StringBuilder();
		
		for(String extension : extensions) {
			ansMaker.append(extension + " " + extensionMap.get(extension) + "\n");
		}
		
		System.out.print(ansMaker);
	}

}