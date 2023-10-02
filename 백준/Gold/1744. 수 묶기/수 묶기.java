import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static List<Integer> plus;
	static List<Integer> minus;
	static int ans;
	
	public static void main(String[] args) {
		input();
		formNumber();
		System.out.println(ans);
	}

	static void input() {
		n = sc.nextInt();
		plus = new ArrayList<>();
		minus = new ArrayList<>();
		
		for(int idx = 0; idx < n; idx++) {
			int nowNumber = sc.nextInt();
			if(nowNumber > 0)
				plus.add(nowNumber);
			else
				minus.add(nowNumber);
		}
		Collections.sort(plus, Collections.reverseOrder());
		Collections.sort(minus);
	}
	
	static void formNumber() {
		for(int idx = 0; idx < plus.size(); idx += 2) {
			if(idx + 1 == plus.size()) {
				ans += plus.get(idx);
				break;
			}
			int sum = plus.get(idx) + plus.get(idx + 1);
			int mlt = plus.get(idx) * plus.get(idx + 1);
			ans += (mlt > sum ? mlt : sum);
		}
		
		for(int idx = 0; idx < minus.size(); idx += 2) {
			if(idx + 1 == minus.size()) {
				ans += minus.get(idx);
				break;
			}
			ans += minus.get(idx) * minus.get(idx + 1);
		}
	}
}