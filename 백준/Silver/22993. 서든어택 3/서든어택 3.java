import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static long junwon;
    static int[] enemies;

    public static void main(String[] args) {
        input();
        System.out.println(playGame() ? "Yes" : "No");
    }

    static void input() {
        n = sc.nextInt();
        junwon = sc.nextLong();
        enemies = new int[n - 1];

        for(int idx = 0; idx < n - 1; idx++) {
            enemies[idx] = sc.nextInt();
        }

        Arrays.sort(enemies);
    }

    static boolean playGame() {
        for(int idx = 0; idx < n - 1; idx++) {
            if(enemies[idx] < junwon) {
                junwon+= enemies[idx];
            } else return false;
        }

        return true;
    }
}