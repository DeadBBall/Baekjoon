import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m, ans, k;
    static String[] board;

    public static void main(String[] args){
        input();
        turnOn();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        board = new String[n];

        for(int y = 0; y < n; y++) {
            board[y] = sc.next();
        }

        k = sc.nextInt();
    }

    static void turnOn() {
        for(int y = 0; y < n; y++) {
            int zeroCnt = 0;

            for(int x = 0; x < m; x++) {
                if(board[y].charAt(x) == '0') zeroCnt++;
            }

            if(zeroCnt <= k && (k - zeroCnt) % 2 == 0) {
                int lamp = 1;

                for(int y2 = 0; y2 < n; y2++) {
                    if(y == y2) continue;

                    if(board[y].equals(board[y2])) lamp++;
                }

                ans = Math.max(ans, lamp);
            }
        }
    }

}