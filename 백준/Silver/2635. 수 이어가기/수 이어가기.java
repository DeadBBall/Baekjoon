import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, maxCnt, maxNum;

    public static void main(String[] args) {
        input();
        searchNumber();
        System.out.println(maxCnt);
        System.out.print(n + " " + maxNum + " ");

        while(n - maxNum >= 0) {
            int tmp = n;
            n = maxNum;
            maxNum = tmp - maxNum;
            System.out.print(maxNum + " ");
        }
    }

    static void input() {
        n = sc.nextInt();
        maxCnt = 1;
    }

    static void searchNumber() {
        for(int num = n; num >= 1; num--) {
            int cnt = 2;
            int prev = n;
            int now = num;

            while(prev - now >= 0) {
                cnt++;
                int tmp = now;
                now = prev - now;
                prev = tmp;
            }

            if(maxCnt < cnt) {
                maxCnt = cnt;
                maxNum = num;
            }
        }
    }

}