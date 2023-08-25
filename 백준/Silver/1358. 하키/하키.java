import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int w, h, x, y, p;
    static int ans;

    public static void main(String[] args) {
        input();
        countPlayer();
        System.out.println(ans);
    }

    static void input() {
        w = sc.nextInt();
        h = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        p = sc.nextInt();
    }

    static void countPlayer() {
        while(p-- > 0) {
            int playerX = sc.nextInt();
            int playerY = sc.nextInt();

            if(isContained(playerY, playerX)) ans++;
        }
    }

    static boolean isContained(int playerY, int playerX) {
        if(y <= playerY && playerY <= y + h && x <= playerX && playerX <= x + w) return true;

        float radius = h / 2;

        int diffPlayerSquare = (int)(Math.pow(playerY - (y + radius), 2) + Math.pow(playerX - x, 2));
        int diffPlayerSquare2 = (int)(Math.pow(playerY - (y + radius), 2) + Math.pow(playerX - (x + w), 2));

        if(diffPlayerSquare <= Math.pow(radius, 2)) return true;

        if(diffPlayerSquare2 <= Math.pow(radius, 2)) return true;

        return false;
    }

}