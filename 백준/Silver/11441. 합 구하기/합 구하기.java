import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int[] accumulatedSum;
    static StringBuilder ansMaker;


    public static void main(String[] args) {
        input();
        calculateSum();
        System.out.println(ansMaker);
    }

    static void input() {
        n = sc.nextInt();
        accumulatedSum = new int[n + 1];
        ansMaker = new StringBuilder();

        for(int numIdx = 1; numIdx <= n; numIdx++) {
            accumulatedSum[numIdx] = accumulatedSum[numIdx - 1] + sc.nextInt();
        }
    }

    static void calculateSum() {
        int m = sc.nextInt();
        while(m-- > 0) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            ansMaker.append(accumulatedSum[end] - accumulatedSum[start - 1]).append("\n");
        }
    }
}