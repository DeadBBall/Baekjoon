import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m, ans;
    static int[] books;

    public static void main(String[] args) {
        input();
        packUp();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        books = new int[n];

        for(int idx = 0; idx < n; idx++) {
            int book = sc.nextInt();
            books[idx] = book;
        }

        ans = (n == 0 ? 0 : 1);
    }

    static void packUp() {
        int nowBox = 0;

        for(int idx = 0; idx < n; idx++) {
            if(nowBox + books[idx] > m) {
                ans++;
                nowBox = books[idx];
            } else nowBox += books[idx];
        }
    }

}