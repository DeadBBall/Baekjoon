import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, ans;

    public static void main(String[] args) {
        input();
        distributeApples();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
    }

    static void distributeApples() {
        while(n-- > 0) {
            int studentCnt = sc.nextInt();
            int appleCnt = sc.nextInt();

            ans += appleCnt % studentCnt;
        }
    }
}