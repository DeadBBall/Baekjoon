import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static long[] rest;
    static long ans;
    
    public static void main(String[] args) {
        input();
        countSection();
        System.out.println(ans);
    }

    static void input() {
    	n = sc.nextInt();
    	m = sc.nextInt();
    	rest = new long[m];
    	
    	int sum = 0;
    	
    	for(int numIdx = 0; numIdx < n; numIdx++) {
    		int nowNumber = sc.nextInt();
    		sum = (sum + nowNumber) % m;
    		rest[sum]++;
    	}
    }
    
    static void countSection() {
    	ans = rest[0];
    	for(int restIdx = 0; restIdx < m; restIdx++) {
    		ans += calculateNumber(restIdx);
    	}
    }
    
    static long calculateNumber(int restIdx) {
    	return rest[restIdx] * (rest[restIdx] - 1) / 2;
    }
}