import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int minX, minY, maxX, maxY, n;

    public static void main(String[] args) {
        input();
        findMin();
        System.out.println((maxY - minY) *(maxX - minX));
    }

    static void input() {
        n = sc.nextInt();
    }

    static void findMin() {
        for(int idx = 0; idx < n; idx++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if(idx == 0) {
                minX = maxX = x;
                minY = maxY = y;
            } else {
                maxY = Math.max(maxY, y);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                minX = Math.min(minX, x);
            }
        }
    }
}