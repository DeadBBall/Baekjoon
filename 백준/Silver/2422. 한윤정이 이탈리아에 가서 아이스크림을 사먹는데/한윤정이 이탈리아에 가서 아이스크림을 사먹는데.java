import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static List<Integer> iceCreams;
    static Set<Integer>[] badCombinations;
    static int n, m, ans;

    public static void main(String[] args) {
        input();
        eatIceCream(1);
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        iceCreams = new ArrayList<>();
        badCombinations = new Set[n + 1];

        while(m-- > 0) {
            int first = sc.nextInt();
            int second = sc.nextInt();

            if(first > second) {
                int tmp = first;
                first = second;
                second = tmp;
            }

            if(badCombinations[first] == null) {
                badCombinations[first] = new HashSet<>();
            }

            badCombinations[first].add(second);
        }
    }

    static void eatIceCream(int now) {
        int iceCreamCount = iceCreams.size();

        if(iceCreamCount == 3) {
            ans++;
            return;
        }

        for(int iceCreamIdx = now; iceCreamIdx <= n; iceCreamIdx++) {
            boolean canEat = true;

            for(int beforeIceCream = 0; beforeIceCream < iceCreamCount; beforeIceCream++) {
                if(!canEatTogether(iceCreams.get(beforeIceCream), iceCreamIdx)) {
                    canEat = false;
                }
            }

            if(canEat) {
                iceCreams.add(iceCreamIdx);
                eatIceCream(iceCreamIdx + 1);
                iceCreams.remove(iceCreamCount);
            }
        }

    }

    static boolean canEatTogether(int first, int second) {
        return badCombinations[first] == null || !badCombinations[first].contains(second);
    }
}