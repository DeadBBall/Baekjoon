import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static final int WHITE = 1;
	static final int BLACK = 2;
	static int n, ans;
	static List<List<Integer>> points;

	public static void main(String[] args) {
		input();
		drawArrow();
		System.out.println(ans);
	}

	static void input() {
		n = SC.nextInt();
		points = new ArrayList<>();

		for (int colorIdx = 0; colorIdx <= n; colorIdx++) {
			points.add(new ArrayList<>());
		}

		for (int pointIdx = 0; pointIdx < n; pointIdx++) {
			int position = SC.nextInt();
			int color = SC.nextInt();

			points.get(color).add(position);
		}
	}

	static void drawArrow() {

		for (int colorIdx = 1; colorIdx <= n; colorIdx++) {
			List<Integer> nowPoints = points.get(colorIdx);
			
			if (!nowPoints.isEmpty()) {
				Collections.sort(nowPoints);
				ans += nowPoints.get(1) - nowPoints.get(0);
				ans += nowPoints.get(nowPoints.size() - 1) - nowPoints.get(nowPoints.size() - 2);
				
				for (int pointIdx = 1; pointIdx < nowPoints.size() - 1; pointIdx++) {
					int left = nowPoints.get(pointIdx) - nowPoints.get(pointIdx - 1);
					int right = nowPoints.get(pointIdx + 1) - nowPoints.get(pointIdx);
					ans += left > right ? right : left;
				}
			}
			
		}
	}

}