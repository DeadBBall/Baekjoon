import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int[] leftCards, rightCards;

    public static void main(String[] args) {
        input();
        System.out.println(playGame(0, 0));
    }

    static void input() {
        n = sc.nextInt();
        leftCards = new int[n];
        rightCards = new int[n];

        for(int cardIdx = 0; cardIdx < n; cardIdx++) {
            leftCards[cardIdx] = sc.nextInt();
        }

        for(int cardIdx = 0; cardIdx < n; cardIdx++) {
            rightCards[cardIdx] = sc.nextInt();
        }
    }

    static int playGame(int left, int right) {
        if(left == n || right == n) return 0;

        int result = Math.max(playGame(left + 1, right + 1), playGame(left + 1, right));

        if(leftCards[left] > rightCards[right]) {
            result = Math.max(result, playGame(left, right + 1) + rightCards[right]);
        }

        return result;
    }

}
