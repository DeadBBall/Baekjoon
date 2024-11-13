import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, k;
    static char[] ans;

    public static void main(String[] args) {
        input();
        System.out.println(findS() ? String.valueOf(ans) : -1);
    }


    static void input() {
        n = sc.nextInt();
        k = sc.nextInt();
        ans = new char[n];
    }

    static boolean findS() {
        int aCnt = 0;
        int bCnt = 0;

        for(int idx = 0; idx <= k; idx++) {
            aCnt = idx;
            bCnt = n - idx;

            if(aCnt * bCnt >= k) break;

            if(idx == k) return false;
        }

        Arrays.fill(ans, 'B');

        if(k == 0) return true;

        for(int idx = 0; idx < aCnt - 1; idx++) {
            ans[idx] = 'A';
        }

        ans[n - 1 - (k - (aCnt - 1) * bCnt)] = 'A';

        return true;
    }
}