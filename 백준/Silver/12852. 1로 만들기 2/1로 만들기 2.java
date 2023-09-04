import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int[] dp;
    static int[] route;
    static StringBuilder ansMaker;

    public static void main(String[] args) {
        input();
        makeOne();
        printAns();
    }

    static void input() {
       n = sc.nextInt();
       dp = new int[n + 1];
       route = new int[n + 1];
       ansMaker = new StringBuilder();
       Arrays.fill(dp, Integer.MAX_VALUE);

       dp[1] = 0;
    }

    static void makeOne() {
        for(int num = 2; num <= n; num++) {
            if(canCalculate(num, 3) && dp[num / 3] + 1 < dp[num]) {
                dp[num] = dp[num / 3] + 1;
                route[num] = num / 3;
            }
            if(canCalculate(num, 2) && dp[num / 2] + 1 < dp[num]) {
                dp[num] = dp[num / 2] + 1;
                route[num] = num / 2;
            }
            if(dp[num - 1] + 1 < dp[num]) {
                dp[num] = dp[num - 1] + 1;
                route[num] = num - 1;
            }
        }
    }

    static boolean canCalculate(int number, int caseNum) {
        if(caseNum == 3) {
            return number % 3 == 0;
        }
        return number % 2 == 0;
    }

    static void printAns() {
        ansMaker.append(dp[n]).append("\n");
        while(n > 0) {
            ansMaker.append(n + " ");
            n = route[n];
        }
        System.out.println(ansMaker);
    }
}