import java.math.BigInteger;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static long[] dp = new long[31];
    static int n;
    static StringBuilder ansMaker = new StringBuilder();

    public static void main(String[] args) {
        countStr();

        while(true) {
            input();

            if(n == 0) break;

            ansMaker.append(dp[n]).append("\n");
        }

        System.out.print(ansMaker);
    }

    static void countStr() {
        for(int cnt = 1; cnt <= 30; cnt++) {
            dp[cnt] = countCombination(cnt * 2, cnt) / (cnt + 1);
        }
    }

    static long countCombination(int a, int b) {
        BigInteger result = new BigInteger("1");

        for(int num = a; num > b; num--) {
            result = result.multiply(new BigInteger(String.valueOf(num)));
        }

        for(int num = b; num > 1; num--) {
            result = result.divide(new BigInteger(String.valueOf(num)));
        }

        return result.longValue();
    }

    static void input() {
        n = sc.nextInt();
    }

}