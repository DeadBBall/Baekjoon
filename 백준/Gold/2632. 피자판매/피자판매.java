import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int target, m, n, ans;
    static int[] aPizza, bPizza;

    public static void main(String[] args) {
        input();
        sellPizza();
        System.out.println(ans);
    }

    static void input() {
        target = sc.nextInt();
        m = sc.nextInt();
        n = sc.nextInt();

        aPizza = getPizza(m);
        bPizza = getPizza(n);
    }

    static int[] getPizza(int totalSize) {
        int[] pizza = new int[totalSize * 2];

        int total = 0;

        for(int idx = 0; idx < totalSize; idx++) {
            int size = sc.nextInt();

            pizza[idx] = pizza[idx + totalSize] = size;
            total += size;
        }

        int[] cases = new int[target];

        if(total == target) {
            ans++;
        } else if(total < target) {
            cases[total]++;
        }

        for(int i = 0; i < totalSize; i++) {
            int sum = 0;

            for(int j = i; j < i + totalSize - 1; j++) {
                sum += pizza[j];
                
                if(sum == target) {
                    ans++;
                    break;
                }

                if(sum > target) break;

                cases[sum]++;
            }
        }

        return cases;
    }

    static void sellPizza() {
        for(int a = 1; a < target; a++) {
            ans += aPizza[a] * bPizza[target - a];
        }
    }
}