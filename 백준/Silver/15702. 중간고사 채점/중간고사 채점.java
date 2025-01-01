import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static int[] scores;

    public static void main(String[] args) {
        input();
        findMax();
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        scores = new int[n + 1];

        for(int idx = 1; idx <= n; idx++) {
            scores[idx] = sc.nextInt();
        }
    }

    static void findMax() {
        int maxScore = 0;
        int bestCandidate = 100001;

        for(int i = 0; i < m; i++) {
            int candidate = sc.nextInt();
            int totalScore = 0;

            for(int j = 0; j < n; j++) {
                char result = sc.next().charAt(0);

                if(result == 'O') {
                    totalScore += scores[j + 1];
                }
            }

            if(totalScore > maxScore) {
                maxScore = totalScore;
                bestCandidate = candidate;
            } else if(totalScore == maxScore && bestCandidate > candidate) {
                bestCandidate = candidate;
            }
        }

        System.out.println(bestCandidate + " " + maxScore);
    }
}