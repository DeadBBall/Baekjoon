import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int[] numbers;

    public static void main(String[] args) {
        input();
        printAns();
    }

    static void input() {
        n = sc.nextInt();
        numbers = new int[n];
        for(int idx = 0; idx < n; idx++) {
            numbers[idx] = sc.nextInt();
        }

        Arrays.sort(numbers);
    }

    static void printAns() {
        StringBuilder ansMaker = new StringBuilder();
        for(int idx = 0; idx < n; idx++) {
            ansMaker.append(numbers[idx]).append("\n");
        }
        System.out.print(ansMaker);
    }
}