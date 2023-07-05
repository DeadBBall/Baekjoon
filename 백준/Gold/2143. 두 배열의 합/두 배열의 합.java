import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int t;
	static int aCnt;
	static int bCnt;
	static List<Integer> aList;
	static List<Integer> bList;
	static long ans;
	
	static void input() {
		t = sc.nextInt();
		aCnt = sc.nextInt();
		aList = new ArrayList<>();
		bList = new ArrayList<>();
		int[] a = new int[aCnt];
		for(int i = 0; i < aCnt; i++) {
			a[i] = sc.nextInt();
		}
		for(int i = 0; i < aCnt; i++) {
			int sum = 0;
			for(int j = i; j < aCnt; j++) {
				sum += a[j];
				aList.add(sum);
			}
		}
		bCnt = sc.nextInt();
		int[] b = new int[bCnt];
		for(int i = 0; i < bCnt; i++) {
			b[i] = sc.nextInt();
		}
		for(int i = 0; i < bCnt; i++) {
			int sum = 0;
			for(int j = i; j < bCnt; j++) {
				sum += b[j];
				bList.add(sum);
			}
		}
		Collections.sort(bList);
	}
	
	static void searchNum() {
		for(int num : aList) {
			int left = 0;
			int right = 0;
			int start = 0;
			int end = bList.size() - 1;
			while(start <= end) {
				int mid = (start + end) / 2;
				if(bList.get(mid) >= t - num) {
					end = mid - 1;
				}
				else {
					start = mid + 1;
				}
			}
			left = end;
			start = 0;
			end = bList.size() - 1;
			while(start <= end) {
				int mid = (start + end) / 2;
				if(bList.get(mid) <= t - num) {
					start = mid + 1;
				}
				else {
					end = mid - 1;
				}
			}
			right = end;
			ans += right - left;
		}
	}
	
	public static void main(String[] args) {
		input();
		searchNum();
		System.out.println(ans);
	}
}