import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n, m, ans;
    static int[][] board;
    static boolean[][] horizontal;

    public static void main(String[] args) {
        input();
        cutPaper(0, 0);
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];
        horizontal = new boolean[n][m];

        for(int y = 0; y < n; y++) {
            String inputBoard = sc.next();

            for(int x = 0; x < m; x++) {
                board[y][x] = inputBoard.charAt(x) - '0';
            }
        }
    }

    static void cutPaper(int nowY, int nowX) {
        if(nowY == n) {
            count();
            return;
        }

        horizontal[nowY][nowX] = true;
        cutPaper(nowX + 1 == m ? nowY + 1 : nowY, (nowX + 1) % m);
        horizontal[nowY][nowX] = false;
        cutPaper(nowX + 1 == m ? nowY + 1 : nowY, (nowX + 1) % m);
    }

    static void count() {
        int sum = 0;

        for(int y = 0; y < n; y++) {
            int now = 0;

            for(int x = 0; x < m; x++) {
                if(horizontal[y][x]) {
                    now = now * 10 + board[y][x];
                }
                if(!horizontal[y][x] || x == m - 1){
                    sum += now;
                    now = 0;
                }
            }
        }

        for(int x = 0; x < m; x++) {
            int now = 0;

            for(int y = 0; y < n; y++) {
                if(!horizontal[y][x]) {
                    now = now * 10 + board[y][x];
                }
                if(horizontal[y][x] || y == n - 1){
                    sum += now;
                    now = 0;
                }
            }
        }

        ans = Math.max(ans, sum);
    }

}