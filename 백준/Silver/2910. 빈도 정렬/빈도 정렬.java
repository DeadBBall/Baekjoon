import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n, c;
	static Integer[] numbers;
	static StringBuilder ansMaker;
	static Map<Integer, Integer> countMap;
	static Map<Integer, Integer> idxMap;
	
	public static void main(String[] args) {
		input();
		sort();
		System.out.println(ansMaker);
	}	
	
	static void input() {
		countMap = new HashMap<>();
		idxMap = new HashMap<>();
		n = sc.nextInt();
		c = sc.nextInt();
		numbers = new Integer[n];
		ansMaker = new StringBuilder();
		
		for(int numIdx = 0; numIdx < n; numIdx++) {
			int nowNumber = sc.nextInt();
			numbers[numIdx] = nowNumber;
			countMap.compute(nowNumber, (k, v) -> (v == null) ? 1 : v + 1);
			if(!idxMap.containsKey(nowNumber))
				idxMap.put(nowNumber, numIdx);
		}
	}
	
	static void sort() {
		Arrays.sort(numbers, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(countMap.get(o2) == countMap.get(o1)) {
					return idxMap.get(o1) - idxMap.get(o2);
				}
				return countMap.get(o2) - countMap.get(o1);
			}
		});
		for(int num : numbers) {
			ansMaker.append(num + " ");
		}
	}

}