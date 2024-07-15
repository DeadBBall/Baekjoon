import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static int[] solutions;

    public static void main(String[] args) {
        input();
        mix();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        solutions = new int[n];

        for(int idx = 0; idx < n; idx++) {
            solutions[idx] = sc.nextInt();
        }

        ans = Integer.MAX_VALUE;
    }

    static void mix() {
        int left = 0;
        int right = n - 1;

        while(left < right) {
            int sum = solutions[left] + solutions[right];

            if(sum < 0) {
                left++;
            } else if(sum > 0) {
                right--;
            } else {
                ans = sum;
                break;
            }

            ans = Math.abs(ans) > Math.abs(sum) ? sum : ans;
        }
    }
}