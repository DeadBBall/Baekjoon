import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m, k, ans;
    static int[] pens;

    public static void main(String[] args) {
        input();
        borrowPens();
        System.out.println(ans == -1 ? "STRESS" : ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        pens = new int[n];

        for(int idx = 0; idx < n; idx++) {
            pens[idx] = sc.nextInt();
        }

        Arrays.sort(pens);
    }

    static void borrowPens() {
        int totalPens = 0;
        int targetCnt = m * k;

        for(int idx = n - 1; idx >= 0; idx--) {
            if(targetCnt <= totalPens) break;

            totalPens += pens[idx];
            ans++;
        }
        
        if(targetCnt > totalPens) ans = -1;
    }

}