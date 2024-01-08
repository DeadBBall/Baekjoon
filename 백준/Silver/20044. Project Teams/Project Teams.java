import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static int n, ans;
	static int[] students;
	
	public static void main(String[] args) {
		input();
		makeTeam();
		System.out.println(ans);
	}
	
	static void input() {
		n = SC.nextInt();
		students = new int[n * 2];
		ans = Integer.MAX_VALUE;
		
		for(int studentIdx = 0; studentIdx < n * 2; studentIdx++) {
			students[studentIdx] = SC.nextInt();
		}
	}
	
	static void makeTeam() {
		Arrays.sort(students);
		
		for(int teamIdx = 0; teamIdx < n; teamIdx++) {
			int team = students[teamIdx] + students[2 * n - 1 - teamIdx];
			
			ans = Math.min(team, ans);
		}
	}
	
}