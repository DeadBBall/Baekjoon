import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
//    static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ansMaker;
    static int n, ans, left, right, up, down;
    static int[][] board;
    static int[][][] sumBoard;

    public static void main(String[] args) throws IOException {
        input();
        dance();
        System.out.println(ans);
        System.out.println(ansMaker);
    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        board = new int[n + 1][n + 1];
        sumBoard = new int[n + 1][n + 1][2];

        for(int y = 1; y <= n; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int x = 1; x <= n; x++) {
                board[y][x] = Integer.parseInt(st.nextToken());
                sumBoard[y][x][0] = sumBoard[y][x - 1][0] + board[y][x];
            }
        }

        for(int x = 1; x <= n; x++) {
            for(int y = 1; y <= n; y++) {
                sumBoard[y][x][1] = sumBoard[y - 1][x][1] + board[y][x];
            }
        }

        ansMaker = new StringBuilder();
        left = up = n / 2;
        right = down = n / 2 + 1;
    }

    static void dance() {
        while(left != 1 || right != n || up != 1 || down != n) {
            int drct = 0;
            int max = 0;

            if(up != 1) {
                int sum = sumBoard[up - 1][right][0] - sumBoard[up - 1][left - 1][0];

                if(max < sum) {
                    max = sum;
                }
            }
            if(down != n) {
                int sum = sumBoard[down + 1][right][0] - sumBoard[down + 1][left - 1][0];

                if(max < sum) {
                    max = sum;
                    drct = 1;
                }
            }
            if(left != 1) {
                int sum = sumBoard[down][left - 1][1] - sumBoard[up - 1][left - 1][1];

                if(max < sum) {
                    max = sum;
                    drct = 2;
                }
            }
            if(right != n) {
                int sum = sumBoard[down][right + 1][1] - sumBoard[up - 1][right + 1][1];

                if(max < sum) {
                    max = sum;
                    drct = 3;
                }
            }

            if(max == 0) break;

            ans += max;

            if(drct == 0) {
                ansMaker.append('U');
                up--;
            } else if(drct == 1) {
                ansMaker.append('D');
                down++;
            } else if(drct == 2) {
                ansMaker.append('L');
                left--;
            } else {
                ansMaker.append('R');
                right++;
            }
        }
    }
}