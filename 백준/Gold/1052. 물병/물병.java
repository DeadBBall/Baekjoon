import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, k, ans;

    public static void main(String[] args) {
        input();
        buyWaterBottle();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        k = sc.nextInt();
        ans = -1;
    }

    static void buyWaterBottle() {
        if(n <= k) {
            ans = 0;
            return;
        }

        int newBottle = 0;

        while(true) {
            int totalBottle = n + newBottle;

            int count = 0;

            while(totalBottle > 0) {
                if(totalBottle % 2 != 0) {
                    count++;
                }
                totalBottle /= 2;
            }

            if(count <= k) {
                ans = newBottle;
                return;
            }

            newBottle++;
        }

    }

}