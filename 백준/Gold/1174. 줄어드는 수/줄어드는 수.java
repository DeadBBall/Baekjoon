import java.util.Scanner;

public class Main {
    static long INF = 9876543210L;
    static Scanner sc = new Scanner(System.in);
    static int n;

    public static void main(String[] args) {
        input();
        System.out.println(findNumber());
    }

    static void input() {
        n = sc.nextInt();
    }

    static long findNumber() {
        long num = 0;

        while(num <= INF && n > 1) {
            num++;

            char[] numArr = String.valueOf(num).toCharArray();

            for (int idx = numArr.length - 1; idx > 0; idx--) {
                if (numArr[idx] >= numArr[idx - 1]) {
                    num /= (long) Math.pow(10, numArr.length - idx);
                    num++;
                    num *= (long) Math.pow(10, numArr.length - idx);
                    numArr = String.valueOf(num).toCharArray();
                }
            }

            if(isDecreasing(numArr)) {
                num = Long.parseLong(String.valueOf(numArr));
                n--;
            }
        }

        return n != 1 ? -1 : num;
    }

    static boolean isDecreasing(char[] num) {
        for(int idx = num.length - 1; idx > 0; idx--) {
            if(num[idx] >= num[idx - 1]) return false;
        }

        return true;
    }

}