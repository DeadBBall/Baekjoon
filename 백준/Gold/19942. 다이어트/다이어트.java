import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Ingredient[] ingredients;
    static boolean[] isSelected;
    static int n, ans, proteinTarget, fatTarget, carbohydrateTarget, vitaminTarget;
    static StringBuilder ansMaker;

    public static void main(String[] args){
        input();
        chooseIngredients(1, 0, 0, 0, 0, 0);
        System.out.print(ansMaker.isEmpty() ? -1 : ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        ingredients = new Ingredient[n + 1];
        isSelected = new boolean[n + 1];

        proteinTarget = sc.nextInt();
        fatTarget = sc.nextInt();
        carbohydrateTarget = sc.nextInt();
        vitaminTarget = sc.nextInt();

        for(int idx = 1; idx <= n; idx++) {
            int protein = sc.nextInt();
            int fat = sc.nextInt();
            int carbohydrate = sc.nextInt();
            int vitamin = sc.nextInt();
            int cost = sc.nextInt();

            ingredients[idx] = new Ingredient(protein, fat, carbohydrate, vitamin, cost);
        }

        ans = Integer.MAX_VALUE;
        ansMaker = new StringBuilder();
    }

    static void chooseIngredients(int start, int protein, int fat, int carbohydrate, int vitamin, int cost) {
        if(protein >= proteinTarget && fat >= fatTarget && carbohydrate >= carbohydrateTarget
                && vitamin >= vitaminTarget) {
            if(cost < ans) {
                ans = cost;
                ansMaker.setLength(0);
                ansMaker.append(ans).append("\n");

                for(int idx = 1; idx <= n; idx++) {
                    if(isSelected[idx]) {
                        ansMaker.append(idx).append(" ");
                    }
                }
            }
        }

        if(start > n) return;

        for(int idx = start; idx <= n; idx++) {
            if(cost + ingredients[idx].cost >= ans) continue;

            isSelected[idx] = true;

            chooseIngredients(idx + 1, protein + ingredients[idx].protein, fat + ingredients[idx].fat,
                    carbohydrate + ingredients[idx].carbohydrate,
                    vitamin + ingredients[idx].vitamin, cost + ingredients[idx].cost);
            
            isSelected[idx] = false;
        }
    }

}

class Ingredient {
    int protein;
    int fat;
    int carbohydrate;
    int vitamin;
    int cost;

    public Ingredient(int protein, int fat, int carbohydrate, int vitamin, int cost) {
        this.protein = protein;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
        this.vitamin = vitamin;
        this.cost = cost;
    }
}