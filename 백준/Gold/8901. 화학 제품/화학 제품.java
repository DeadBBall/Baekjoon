import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker = new StringBuilder();
    static int a, b, c, abCost, bcCost, caCost, ans;

    public static void main(String[] args){
        int t = sc.nextInt();

        while(t-- > 0) {
            input();
            makeMoney();
            ansMaker.append(ans).append("\n");
        }

        System.out.print(ansMaker);
    }

    static void input() {
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        abCost = sc.nextInt();
        bcCost = sc.nextInt();
        caCost = sc.nextInt();

        ans = 0;
    }

    static void makeMoney() {
        for(int ab = 0; ab <= Math.min(a, b); ab++) {
            for(int bc = 0; bc <= Math.min(b - ab, c); bc++) {
                int ca = Math.min(a - ab, c - bc);

                int profit = ab * abCost + bc * bcCost + ca * caCost;

                ans = Math.max(ans, profit);
            }
        }
    }

}