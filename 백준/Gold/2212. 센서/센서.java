import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, k;
    static int[] road;
    static int[] diffs;
    static int ans;
    
    public static void main(String[] args) {
        input();
        calculateLength();
        System.out.println(ans);
    }

    static void input() {
    	n = sc.nextInt();
    	k = sc.nextInt();
    	road = new int[n];
    	diffs = new int[n - 1];
    	
    	for(int idx = 0; idx < n; idx++) {
    		int sensorPosition = sc.nextInt();
    		road[idx] = sensorPosition;
    	}
    	
    	Arrays.sort(road);
    	for(int idx = 0; idx < n - 1; idx++) {
    		diffs[idx] = road[idx + 1] - road[idx];
    	}
    	Arrays.sort(diffs);
    	
    }
    static void calculateLength() {
    	for(int idx = 0; idx < n - k; idx++) {
    		ans += diffs[idx];
    	}
    }
}