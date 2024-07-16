import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;
    static Map<Integer, Integer> arrows;

    public static void main(String[] args) {
        input();
        shootArrows();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        arrows = new HashMap<>();
    }

    static void shootArrows() {
        while(n-- > 0) {
            int height = sc.nextInt();

            if(!arrows.containsKey(height)) {
                ans++;
            } else if(arrows.get(height) == 1) {
                arrows.remove(height);
            } else {
                arrows.put(height, arrows.get(height) - 1);
            }

            arrows.put(height - 1, arrows.getOrDefault(height - 1 , 0) + 1);
        }
    }
}