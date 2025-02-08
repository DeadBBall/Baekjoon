import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int ans;
    static int[] scores, scores2;

    public static void main(String[] args) {
        input();
        System.out.println(ans);
    }

    static void input() {
        scores = new int[4];
        scores2 = new int[2];

        for(int idx = 0; idx < 4; idx++) {
            scores[idx] = sc.nextInt();
        }

        for(int idx = 0; idx < 2; idx++) {
            scores2[idx] = sc.nextInt();
        }

        Arrays.sort(scores);
        Arrays.sort(scores2);

        for(int idx = 3; idx > 0; idx--) {
            ans += scores[idx];
        }

        ans += scores2[1];
    }
}