import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static double area;
    static double circumference;

    public static void main(String[] args) {
        input();
        calculateCircle();
        System.out.println(area);
        System.out.println(circumference);
    }

    static void input() {
        n = sc.nextInt();
    }

    static void calculateCircle() {
        area = n * n * Math.PI;
        circumference = n * n * 2;
    }

}