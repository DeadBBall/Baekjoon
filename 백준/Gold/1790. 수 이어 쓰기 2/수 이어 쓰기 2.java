import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static long n, k, ans;

    public static void main(String[] args) {
        input();
        makeNumber();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        k = sc.nextInt();
    }

    static void makeNumber() {
        long cnt = 9;

        long len = 1;

        while(k > len * cnt) {
            k -= len * cnt;
            len++;
            cnt *= 10;
        }

        k--;

        long num = (long)Math.pow(10, (len - 1)) + (k / len);

        if(num > n) {
            ans = -1;
        } else {
            ans = String.valueOf(num).charAt((int)(k % len)) - '0';
        }
    }
}