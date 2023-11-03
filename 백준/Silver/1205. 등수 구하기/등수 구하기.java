import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, taesu, p, ans;
    static Integer[] scores;

    public static void main(String[] args) {
        input();
        checkRank();
        System.out.println(ans);
    }
    static void input() {
        n = sc.nextInt();
        taesu = sc.nextInt();
        p = sc.nextInt();
        ans = -1;

        scores = new Integer[n + 1];
        for(int idx = 0; idx < n; idx++) {
            scores[idx] = sc.nextInt();
        }
        scores[n] = taesu;
    }

    static void checkRank() {
        Arrays.sort(scores, Collections.reverseOrder());
        if(p > n) {
            for(int idx = 0; idx < n + 1; idx++) {
                if(scores[idx].equals(taesu)) {
                    ans = idx + 1;
                    return;
                }
            }
        }
        for(int idx = 0; idx < p; idx++) {
            if(scores[idx].equals(taesu)) {
                if(!scores[p].equals(taesu)) {
                    ans = idx + 1;
                    return;
                }
            }
        }

    }
}