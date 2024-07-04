import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Set<Integer> sums;
    static int n, ans;
    static int[] nums;

    public static void main(String[] args) {
        input();
        add(0, 0);
        searchNum();
        System.out.println(ans);
    }

    static void input() {
        sums = new HashSet<>();
        n = sc.nextInt();
        nums = new int[n];

        for(int idx = 0; idx < n; idx++) {
            nums[idx] = sc.nextInt();
        }

    }

    static void add(int now, int sum) {
        if(now == n) {
            if(sum != 0) {
                sums.add(sum);
            }

            return;
        }

        add(now + 1, sum + nums[now]);
        add(now + 1, sum);
    }

    static void searchNum() {
        int num = 1;

        while(true) {
            if(!sums.contains(num)) {
                ans = num;
                break;
            }
            num++;
        }
    }

}