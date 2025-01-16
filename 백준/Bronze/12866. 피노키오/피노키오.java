import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;
    static Scanner sc = new Scanner(System.in);
    static String l;
    static int[] counts;
    static long ans;
    static int n;

    public static void main(String[] args) {
        input();
        countDNA();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        l = sc.next();
        counts = new int[4];
    }

    static void countDNA() {
        for(int idx = 0; idx < n; idx++) {
            char now = l.charAt(idx);

            if(now == 'A') {
                counts[0]++;
            } else if(now == 'C') {
                counts[1]++;
            } else if(now == 'G') {
                counts[2]++;
            } else {
                counts[3]++;
            }
        }

        ans = counts[0];

        for(int idx = 1; idx < 4; idx++) {
            ans = ans * counts[idx] % MOD;
        }
    }

}