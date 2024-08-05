import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int[] subjects;
    static int n, m, ans;

    public static void main(String[] args) {
        input();
        apply();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();

        subjects = new int[n];

        for(int idx = 0; idx < n; idx++) {
            int p = sc.nextInt();
            int l = sc.nextInt();

            int[] mil = new int[p];

            while(--p >= 0) {
                mil[p] = sc.nextInt();
            }

            Arrays.sort(mil);

            subjects[idx] = mil.length - l < 0 ? 1 : mil[mil.length - l];
        }
    }

    static void apply() {
        Arrays.sort(subjects);

        for(int idx = 0; idx < n; idx++) {
            if(m >= subjects[idx]) {
                m -= subjects[idx];
                ans++;
            } else break;
        }
    }
}