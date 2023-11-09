import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans, maxNumber;
    static int[][] numbers;

    public static void main(String[] args) {
        input();
        checkAll();
        System.out.println(ans);
    }
    static void input() {
        n = sc.nextInt();
        numbers = new int[n][5];
        maxNumber = Integer.MIN_VALUE;

        for(int pIdx = 0; pIdx < n; pIdx++) {
            for(int nIdx = 0; nIdx < 5; nIdx++) {
                numbers[pIdx][nIdx] = sc.nextInt();
            }
        }
    }

    static void checkAll() {
        for(int pIdx = n - 1; pIdx >= 0; pIdx--) {
            calculateMaxNumber(pIdx, 0, 0, 0);
            if(maxNumber == 9) return;
        }
    }

    static void calculateMaxNumber(int pIdx, int nIdx, int cnt, int sum) {
        if(cnt == 3) {
            sum %= 10;
            if(maxNumber < sum) {
                maxNumber = sum;
                ans = pIdx + 1;
                return;
            }
        }

        if(pIdx == n) return;

        for(int idx = nIdx; idx < 5; idx++) {
            calculateMaxNumber(
                    pIdx, idx + 1, cnt + 1, sum + numbers[pIdx][idx]);
        }

    }

}