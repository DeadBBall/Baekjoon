import java.util.*;

public class Main {
    static final int[] time = {300, 60, 10};
    static Scanner sc = new Scanner(System.in);
    static int t;

    public static void main(String[] args) {
        input();
        cook();
    }

    static void input() {
        t = sc.nextInt();
    }
    static void cook() {
        int[] ans = new int[3];

        for(int idx = 0; idx < 3; idx++) {
            ans[idx] += t / time[idx];

            t %= time[idx];
        }

        if(t > 0) {
            System.out.println(-1);
        } else {
            System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
        }
    }
}