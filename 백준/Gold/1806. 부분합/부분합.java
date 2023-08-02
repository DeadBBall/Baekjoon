import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static final int INF = 100001;
    static int[] sumArr;
    static int n;
    static int k;
    static long ans;

    public static void main(String[] args) {
        input();
        searchSum();
        System.out.println(ans != INF ? ans : 0);
    }

    static void input() {
        n = sc.nextInt();
        k = sc.nextInt();

        sumArr = new int[n + 1];

        ans = INF;
        sumArr[0] = 0;

        for(int inputCnt = 1; inputCnt <= n; inputCnt++) {
            sumArr[inputCnt] = sumArr[inputCnt - 1] + sc.nextInt();
        }

    }

    static void searchSum() {
        if(sumArr[0] >= k) {
            ans = 1;
            return;
        }

        int left = 0;

        for(int right = 1; right <= n; right++) {
            int nowSum = sumArr[right] - sumArr[left];

            if(nowSum >= k) ans = Math.min(ans, right - left);

            while(nowSum >= k) {
                nowSum = sumArr[right] - sumArr[++left];

                if(nowSum >= k) ans = Math.min(ans, right - left);
            }

        }

    }

}
