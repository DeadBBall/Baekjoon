import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static char[][] board;
    static int ans;
    static void input() {
        n = sc.nextInt();
        board = new char[n][n];
        for(int y = 0; y < n; y++) {
            String tmp = sc.next();
            board[y] = tmp.toCharArray();
        }
        searchLongCombo();
    }

    static void searchLongCombo() {
        for(int y = 0; y < n; y++) {
            char now = 0;
            int len = 1;
            for(int x = 0; x < n; x++) {
                if(x == 0) {
                    now = board[y][x];
                }
                else {
                    if(now == board[y][x]) {
                        len++;
                        if(x == n - 1) {
                            ans = Math.max(ans, len);
                        }
                    }
                    else {
                        ans = Math.max(ans, len);
                        len = 1;
                        now = board[y][x];
                    }
                }
            }
        }
        for(int x = 0; x < n; x++) {
            char now = 0;
            int len = 1;
            for(int y = 0; y < n; y++) {
                if(y == 0) {
                    now = board[y][x];
                }
                else {
                    if(now == board[y][x]) {
                        len++;
                        if(y == n - 1) {
                            ans = Math.max(ans, len);
                        }
                    }
                    else {
                        ans = Math.max(ans, len);
                        len = 1;
                        now = board[y][x];
                    }
                }
            }
        }
    }

    static void changeCandy() {
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n - 1; x++) {
                char tmp = board[y][x];
                board[y][x] = board[y][x + 1];
                board[y][x + 1] = tmp;
                searchLongCombo();
                tmp = board[y][x];
                board[y][x] = board[y][x + 1];
                board[y][x + 1] = tmp;
            }
        }
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n - 1; y++) {
                char tmp = board[y][x];
                board[y][x] = board[y + 1][x];
                board[y + 1][x] = tmp;
                searchLongCombo();
                tmp = board[y][x];
                board[y][x] = board[y + 1][x];
                board[y + 1][x] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        input();
        changeCandy();
        System.out.println(ans);
      }
}