import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, target, oneCnt;

    public static void main(String[] args) {
        input();
        System.out.println(waterTree() ? "YES" : "NO");
    }

    static void input() {
        n = sc.nextInt();

        while(n-- > 0) {
            int height = sc.nextInt();

            if(height % 2 == 1) {
                height--;
                oneCnt++;
            }

            target += height;
        }
    }

    static boolean waterTree() {
        if(target < oneCnt * 2) return false;

        target -= oneCnt * 2;

        return target % 3 == 0;
    }

}