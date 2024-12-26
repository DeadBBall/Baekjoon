import java.util.Scanner;

public class Main {
    static final char DOWN = 'D';
    static final char LEFT = 'L';
    static final char UP = 'U';
    static Scanner sc = new Scanner(System.in);
    static int n, m, ans;
    static String[] board;
    static int[][] dp;

    public static void main(String[] args) {
        input();
        escapeMaze();
        System.out.println(ans);
    }

    static void input() {
        n = sc.nextInt();
        m = sc.nextInt();
        board = new String[n];

        for(int y = 0; y < n; y++) {
            board[y] = sc.next();
        }

        dp = new int[n][m];
    }

    static void escapeMaze() {
        for(int y = 0; y < n; y++) {
            for(int x = 0; x < m; x++) {
                if(dfs(y, x)) ans++;
            }
        }
    }

    static boolean dfs(int y, int x) {
        int ny = y;
        int nx = x;

        if(board[y].charAt(x) == DOWN) {
            ny++;
        } else if(board[y].charAt(x) == UP) {
            ny--;
        } else if(board[y].charAt(x) == LEFT) {
            nx--;
        } else {
            nx++;
        }

        if(!canMove(ny, nx)) {
            dp[y][x] = 2;
            return true;
        }

        if(dp[ny][nx] == 2) return true;
        else if(dp[ny][nx] == 1) return false;

        dp[y][x] = 1;

        if(dfs(ny, nx)) {
            dp[y][x] = 2;
            return true;
        }

        return false;
    }

    static boolean canMove(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}