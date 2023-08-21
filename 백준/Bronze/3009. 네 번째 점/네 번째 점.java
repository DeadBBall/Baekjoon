import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int x1, x2, x3, y1, y2, y3;
    static int xAns, yAns;

    public static void main(String[] args) {
        input();
        searchPoint();
        System.out.println(yAns + " " + xAns);
    }

    static void input() {
        y1 = sc.nextInt();
        x1 = sc.nextInt();
        y2 = sc.nextInt();
        x2 = sc.nextInt();
        y3 = sc.nextInt();
        x3 = sc.nextInt();
    }

    static void searchPoint() {
        if(y1 == y2) {
            yAns = y3;
        } else if(y1 == y3) {
            yAns = y2;
        } else {
            yAns = y1;
        }

        if(x1 == x2) {
            xAns = x3;
        } else if(x1 == x3) {
            xAns = x2;
        } else {
            xAns = x1;
        }

    }

}