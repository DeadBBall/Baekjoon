import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;

    public static void main(String[] args) {
        input();
        makeMoney();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
    }

    static void makeMoney() {
        int min = Integer.MAX_VALUE;
        
        for(int day = 0; day < n; day++) {
            int cost = sc.nextInt();
            
            min = Math.min(min, cost);
            ans = Math.max(cost - min, ans);
        }
    }

}