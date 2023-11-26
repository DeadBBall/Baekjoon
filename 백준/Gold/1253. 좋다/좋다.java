import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n, ans;
	static Map<Integer, Integer> numberMap;
	static int[] numbers;
	
	public static void main(String[] args) {
		input();
		countGoodNumber();
		System.out.println(ans);
	}	
	
	static void input() {
		n = sc.nextInt();
		numbers = new int[n];
		numberMap = new HashMap<>();
		
		for(int numIdx = 0; numIdx < n; numIdx++) {
			int number = sc.nextInt();
			numbers[numIdx] = number;
	        numberMap.compute(number, (k, v) -> (v == null) ? 1 : v + 1);
		}
	}

	static void countGoodNumber() {
		for(int numIdx = 0; numIdx < n; numIdx++) {
			int now = numbers[numIdx];
			
			for(int first : numberMap.keySet()) {
				if((first == now && numberMap.get(first) == 1) || (now - first == now && numberMap.get(now - first) == 1)) continue;
				
				if(numberMap.containsKey(now - first)) {
					
					if(now - first == first && first == now) {
						if(numberMap.get(first) > 2)  {
							ans++;
							break;
						}
						continue;
					}
					
					else if(now - first == first && numberMap.get(now - first) > 1) {
						ans++;
						break;
					}
					
					else if(now - first != first) {
						ans++;
						break;
					}
				}
			}
		}
	}
}