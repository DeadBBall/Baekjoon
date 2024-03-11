import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static long ans;
    static int n;
    static Stack<Integer> buildings;

    public static void main(String[] args) {
        input();
        checkRoof();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        buildings = new Stack<>();
    }

    static void checkRoof() {
        buildings.push(sc.nextInt());

        for(int buildingIdx = 1; buildingIdx < n; buildingIdx++) {
            int building = sc.nextInt();

            while(!buildings.isEmpty() && buildings.peek() <= building) {
                buildings.pop();
            }

            ans += buildings.size();

            buildings.push(building);
        }
    }

}