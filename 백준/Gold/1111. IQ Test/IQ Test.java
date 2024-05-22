import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int[] numbers;

    public static void main(String[] args) {
        input();
        test();
    }

    static void input() {
        n = sc.nextInt();
        numbers = new int[n];

        for(int numIdx = 0; numIdx < n; numIdx++) {
            numbers[numIdx] = sc.nextInt();
        }

    }

    static void test() {
        if(n == 1 || (n == 2 && numbers[0] != numbers[1])) {
            System.out.println("A");
            return;
        }
        else if(n == 2) {
            System.out.println(numbers[0]);
            return;
        }

        int a, b;

        if(numbers[0] == numbers[1]) {
            a = 1;
            b = 0;
        }
        else {
            a = (numbers[2] - numbers[1]) / (numbers[1] - numbers[0]);
            b = numbers[1] - numbers[0] * a;
        }

        if(check(a, b)) {
            System.out.println(numbers[n - 1] * a + b);
        }
        else {
            System.out.println("B");
        }
    }

    static boolean check(int a, int b) {
        for(int idx = 0; idx < n - 1; idx++) {
            if(numbers[idx + 1] != (numbers[idx] * a + b)) {
                return false;
            }
        }

        return true;
    }

}