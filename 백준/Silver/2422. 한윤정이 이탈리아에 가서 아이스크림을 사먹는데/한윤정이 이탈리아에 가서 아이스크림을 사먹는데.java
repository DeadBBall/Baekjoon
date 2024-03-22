import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int[] iceCreams;
    static boolean[][] badCombinations;
    static int n, m, ans;

    public static void main(String[] args) {
        input();
        eatIceCream(0, 1);
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        iceCreams = new int[3];
        badCombinations = new boolean[n + 1][n + 1];

        while(m-- > 0) {
            int first = sc.nextInt();
            int second = sc.nextInt();

            badCombinations[first][second] = true;
            badCombinations[second][first] = true;
        }
    }

    static void eatIceCream(int iceCreamCount, int now) {
        if(iceCreamCount == 3) {
            ans++;
            return;
        }

        for(int iceCreamIdx = now; iceCreamIdx <= n; iceCreamIdx++) {
            boolean canEat = true;

            for(int beforeIceCream = 0; beforeIceCream < iceCreamCount; beforeIceCream++) {
                if(badCombinations[iceCreams[beforeIceCream]][iceCreamIdx]) {
                    canEat = false;
                    break;
                }
            }

            if(canEat) {
                iceCreams[iceCreamCount] = iceCreamIdx;
                eatIceCream(iceCreamCount + 1, iceCreamIdx + 1);
            }
        }

    }
}