import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static long k, ans;
    static int[] speed;

    public static void main(String[] args) {
        input();
        moveBox();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        k = sc.nextLong();

        speed = new int[n];

        for(int idx = 0; idx < n; idx++) {
            speed[idx] = sc.nextInt();
        }

        Arrays.sort(speed);

        ans = Long.MAX_VALUE;
    }

    static void moveBox() {

        for(int idx = 0; idx < n - 1; idx++) {
            long team = (long) speed[0] * (idx + 1);
            long otherTeam = (long) speed[idx + 1] * (n - idx - 1);

            long time = (k + team + otherTeam - 1) / (team + otherTeam);

            ans = Math.min(ans, time);
        }
    }

}