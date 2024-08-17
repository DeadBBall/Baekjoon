import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, k, right;
    static int[] scores;

    public static void main(String[] args) {
        input();
        System.out.println(grade());
    }

    static void input() {
        n = sc.nextInt();
        k = sc.nextInt();
        scores = new int[n];

        for(int idx = 0; idx < n; idx++) {
            scores[idx] = sc.nextInt();
            right += scores[idx];
        }
    }

    static int grade() {
        int left = 0;

        while(left <= right) {
            int mid = (left + right) >> 1;

            if(calculateScore(mid) < k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    static int calculateScore(int limit) {
        int groupCnt = 0;
        int sum = 0;

        for(int idx = 0; idx < n; idx++) {
            sum += scores[idx];

            if(sum >= limit) {
                groupCnt++;
                sum = 0;
            }
        }

        return groupCnt;
    }

}