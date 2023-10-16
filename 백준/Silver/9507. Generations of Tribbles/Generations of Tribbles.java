import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ansMaker = new StringBuilder();
    static long[] fibo = new long[68];
    static int n;

    public static void main(String[] args) {
        int t = sc.nextInt();
        calculateFibo();
        while(t-- > 0) {
            n = sc.nextInt();
            ansMaker.append(fibo[n] + "\n");
        }
        System.out.println(ansMaker);
    }
    static void calculateFibo() {
        fibo[0] = 1;
        fibo[1] = 1;
        fibo[2] = 2;
        fibo[3] = 4;
        for(int idx = 4; idx < 68; idx++) {
            fibo[idx] = fibo[idx - 1] + fibo[idx - 2] + fibo[idx - 3] + fibo[idx - 4];
        }
    }

}