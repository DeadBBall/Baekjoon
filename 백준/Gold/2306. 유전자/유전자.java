import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String dna;
    static int[][] dp;

    public static void main(String[] args) {
        input();
        analyze();
        System.out.println(dp[0][dna.length() - 1]);
    }

    static void input() {
        dna = sc.next();
        dp = new int[dna.length()][dna.length()];
    }

    static void analyze() {
        for(int size = 1; size < dna.length(); size++) {
            for(int left = 0; left + size < dna.length(); left++) {
                int right = left + size;

                if((dna.charAt(left) == 'a' && dna.charAt(right) == 't') ||
                        (dna.charAt(left) == 'g' && dna.charAt(right) == 'c')) {
                    dp[left][right] = dp[left + 1][right - 1] + 2;
                }

                for(int mid = left + 1; mid < right; mid++) {
                    dp[left][right] = Math.max(dp[left][right], dp[left][mid] + dp[mid][right]);
                }
            }
        }
    }
}