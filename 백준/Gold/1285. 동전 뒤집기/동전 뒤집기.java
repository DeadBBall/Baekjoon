import java.util.*;

public class Main {
    static final char HEAD = 'H';
    static Scanner sc = new Scanner(System.in);
    static int[] board;
    static int n, ans;

    public static void main(String[] args) {
        input();
        reverse(0);
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        board = new int[n];

        for(int y = 0; y < n; y++) {
            String line = sc.next();

            for(int x = 0; x < n; x++) {
                if(line.charAt(x) != HEAD) {
                    board[y] |= (1 << x);
                }
            }
        }

        ans = n * n;
    }

    static void reverse(int idx) {
        if(idx == n) {
            int totalTail = 0;

            for(int x = 1; x < (1 << n); x <<= 1) {
                int nowTail = 0;

                for(int y = 0; y < n; y++) {
                    if((board[y] & x) == x) {
                        nowTail++;
                    }
                }

                totalTail += Math.min(nowTail, n - nowTail);
                
                if(totalTail >= ans) return;
            }

            ans = Math.min(ans, totalTail);
            return;
        }

        reverse(idx + 1);

        board[idx] = ~board[idx];
        reverse(idx + 1);
        board[idx] = ~board[idx];
    }
}