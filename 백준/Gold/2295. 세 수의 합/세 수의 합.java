import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static int[] numbers, sums;

    public static void main(String[] args) {
        input();
        findMaxNumber();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        numbers = new int[n];

        for(int idx = 0; idx < n; idx++) {
            int num = sc.nextInt();
            numbers[idx] = num;
        }

        sums = new int[n * (n + 1) / 2];

        int sumIdx = 0;

        for(int x = 0; x < n; x++) {
            for(int y = x; y < n; y++) {
                sums[sumIdx++] = numbers[x] + numbers[y];
            }
        }

        Arrays.sort(sums);
    }

    static void findMaxNumber() {
        for(int k = 0; k < n; k++) {
            for(int z = 0; z < n; z++) {
                int diff = numbers[k] - numbers[z];

                int left = 0;
                int right = sums.length - 1;

                while(left <= right) {
                    int mid = (left + right) >> 1;

                    if(sums[mid] > diff) {
                        right = mid - 1;
                    }
                    else if(sums[mid] < diff) {
                        left = mid + 1;
                    }
                    else {
                        ans = Math.max(ans, numbers[k]);
                        break;
                    }
                }

            }
        }
    }

}