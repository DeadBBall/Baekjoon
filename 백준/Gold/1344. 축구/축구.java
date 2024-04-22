import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static boolean[] primeNumbers;
    static double a, b, ans;
    static double[][][] dp;

    public static void main(String[] args) {
        input();
        playFootball();
        System.out.println(ans);
    }

    static void input() {
        a = (double) sc.nextInt() / 100;
        b = (double) sc.nextInt() / 100;
        dp = new double[19][19][19];

        dp[0][0][0] = 1;
        primeNumbers = new boolean[19];
    }

    static void playFootball() {
        for(int time = 1; time <= 18; time++) {
            for(int aGoal = 0; aGoal <= time; aGoal++) {
                for(int bGoal = 0; bGoal <= time; bGoal++) {
                    if(aGoal > 0) {
                        dp[time][aGoal][bGoal] += dp[time - 1][aGoal - 1][bGoal] * a * (1 - b);
                    }
                    if(bGoal > 0) {
                        dp[time][aGoal][bGoal] += dp[time - 1][aGoal][bGoal - 1] * (1 - a) * b;
                    }
                    if(aGoal > 0 && bGoal > 0) {
                        dp[time][aGoal][bGoal] += dp[time - 1][aGoal - 1][bGoal - 1] * a * b;
                    }

                    dp[time][aGoal][bGoal] += dp[time - 1][aGoal][bGoal] * (1 - a) * (1 - b);
                }
            }
        }

        for(int num = 1; num <= 18; num++) {
            primeNumbers[num] = isPrime(num);
        }

        for(int aGoal = 0; aGoal <= 18; aGoal++) {
            for(int bGoal = 0; bGoal <= 18; bGoal++) {
                if(primeNumbers[aGoal] || primeNumbers[bGoal]) {
                    ans += dp[18][aGoal][bGoal];
                }
            }
        }

    }

    static boolean isPrime(int num) {
        if(num < 2) return false;

        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) return false;
        }

        return true;
    }

}