import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int x1, x2, y1, y2, r1, r2;
    static int ans;

    public static void main(String[] args) {
        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            input();
            searchMarine();
            System.out.println(ans);
        }
    }

    static void input() {
        x1 = sc.nextInt();
        y1 = sc.nextInt();
        r1 = sc.nextInt();

        x2 = sc.nextInt();
        y2 = sc.nextInt();
        r2 = sc.nextInt();

        ans = 0;
    }

    static void searchMarine() {
       int dist = (int)(Math.pow((double)x2 - x1, 2) + Math.pow((double) y2 - y1, 2));

       if(x1 == x2 && y1 == y2 && r1 == r2) ans = -1;

       else if(dist > Math.pow(r1 + r2, 2)) ans = 0;

       else if(dist < Math.pow(r1 - r2, 2)) ans = 0;

       else if(dist == Math.pow(r1 - r2, 2)) ans = 1;
       
       else if(dist == Math.pow(r1 + r2, 2)) ans = 1;
       
       else ans = 2;

    }

}