import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m, low, high, ans;
    static int[] numbers;

    public static void main(String[] args) {
        input();
        divideSections();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        numbers = new int[n];

        for(int idx = 0; idx < n; idx++) {
            numbers[idx] = sc.nextInt();
            high = Math.max(high, numbers[idx]);
        }
    }

    static void divideSections() {
        while(low <= high) {
            int mid = (low + high) >> 1;

            if(countSections(mid) > m) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
    }

    static int countSections(int target) {
        int sectionCnt = 1;
        int max = 0;
        int min = 10001;

        for(int idx = 0; idx < n; idx++) {
            min = Math.min(min, numbers[idx]);
            max = Math.max(max, numbers[idx]);

            if(max - min > target) {
                sectionCnt++;
                min = numbers[idx];
                max = numbers[idx];
            }
        }

        return sectionCnt;
    }

}