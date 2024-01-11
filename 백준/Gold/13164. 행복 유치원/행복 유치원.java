import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static final Scanner SC = new Scanner(System.in);
	static int n, k, ans;
	static int[] studentsDiff;

    public static void main(String[] args) {
    	input();
    	makeTeam();
    	System.out.println(ans);
    }

    static void input() {
    	n = SC.nextInt();
    	k = SC.nextInt();
    	studentsDiff = new int[n - 1];
    	
    	int prev = SC.nextInt();
    	
    	for(int studentIdx = 0; studentIdx < n - 1; studentIdx++) {
    		int next = SC.nextInt();
    		
    		studentsDiff[studentIdx] = next - prev;
    		prev = next;
    	}
    }

    static void makeTeam() {
    	Arrays.sort(studentsDiff);
    	
    	for(int diffIdx = 0; diffIdx < n - k; diffIdx++) {
    		ans += studentsDiff[diffIdx];
    	}
    }
    

}