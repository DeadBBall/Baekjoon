import java.util.*;

public class Main {
    static final int SIZE = 7;
    static Scanner sc = new Scanner(System.in);
    static int sum, min;

    public static void main(String[] args) {
        input();
        sumOdd();
    }

    static void input() {
        min = Integer.MAX_VALUE;
    }

    static void sumOdd() {
        for(int idx = 0; idx < SIZE; idx++) {
            int num = sc.nextInt();

            if(num % 2 == 1) {
                sum += num;
                min = Math.min(num, min);
            }
        }

        if(sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}