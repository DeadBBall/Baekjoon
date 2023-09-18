import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int[] scores;
    static int ans;

    public static void main(String[] args) {
        input();
        changeScore();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        scores = new int[n + 1];

        for(int scoreIdx = 1; scoreIdx <= n; scoreIdx++) {
            scores[scoreIdx] = sc.nextInt();
        }
    }

    static void changeScore() {
        int beforeScore = scores[n];
        for(int scoreIdx = n - 1; scoreIdx > 0; scoreIdx--) {
            int nowScore = scores[scoreIdx];

            if(beforeScore <= nowScore) {
                ans += nowScore - (beforeScore - 1);
                beforeScore = beforeScore - 1;
            }
            else
                beforeScore = nowScore;
        }
    }
}