import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int target, m, n, ans;
    static Map<Integer, Integer> aPizza, bPizza;

    public static void main(String[] args) {
        input();
        sellPizza();
        System.out.println(ans);
    }

    static void input() {
        target = sc.nextInt();
        m = sc.nextInt();
        n = sc.nextInt();

        aPizza = getPizzaMap(m);
        bPizza = getPizzaMap(n);
    }

    static Map<Integer, Integer> getPizzaMap(int totalSize) {
        int[] pizza = new int[totalSize * 2];
        int sum = 0;

        for(int idx = 0; idx < totalSize; idx++) {
            int size = sc.nextInt();

            sum += size;
            pizza[idx] = pizza[idx + totalSize] = size;
        }

        Map<Integer, Integer> pizzaMap = new HashMap<>();
        pizzaMap.put(sum, 1);

        for(int i = 0; i < totalSize; i++) {
            sum = 0;

            for(int j = i; j < i + totalSize - 1; j++) {
                sum += pizza[j];
                pizzaMap.put(sum, pizzaMap.getOrDefault(sum, 0) + 1);
            }
        }

        return pizzaMap;
    }

    static void sellPizza() {
        for(int size : aPizza.keySet()) {
            if(size >= target) continue;

            ans += aPizza.get(size) * bPizza.getOrDefault(target - size, 0);
        }

        ans += aPizza.getOrDefault(target, 0);
        ans += bPizza.getOrDefault(target, 0);
    }
}